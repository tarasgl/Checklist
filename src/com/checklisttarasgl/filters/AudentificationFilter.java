package com.checklisttarasgl.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AudentificationFilter")
public class AudentificationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse responce = (HttpServletResponse) resp;

        String uri = request.getRequestURI();

        HttpSession session = request.getSession(false);

        if(session != null  && session.getAttribute("userID")!=null){

            chain.doFilter(req, resp);
        }
        else {
            responce.sendRedirect("login");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
