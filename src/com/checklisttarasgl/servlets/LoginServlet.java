package com.checklisttarasgl.servlets;

import com.checklisttarasgl.classes.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    static final String db_username = "userlogin";
    static final String db_password = "useruser123";

    static final String url = "jdbc:sqlserver://DESKTOP-HNAFTUU\\SQLEXPRESS;databaseName=Checklist";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usn = request.getParameter("username");
        String psw = request.getParameter("password");
        String password = null;
        int userId = -1;

        Connection conn = DBConnection.getConnection();
        String sqlQuery = "SELECT  [id] ,[username] ,[password] FROM [Checklist].[dbo].[User] WHERE [username] = ?;";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery) ;
            preparedStatement.setString(1,usn);

            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                password = res.getString("password");
                userId = res.getInt("id");
            }


            conn.close();
        } catch (SQLException ex){
            System.err.println(ex.getMessage()+ex.getSQLState());
            response.sendRedirect("/error");
        }



        if(psw.equals(password)/*&& userId != -1*/){
            HttpSession session = request.getSession();
            session.setAttribute("userID", userId);
            //setting session to expiry in 10 mins
            session.setMaxInactiveInterval(10*60);

            response.sendRedirect("home");
        }
        else{
            request.setAttribute("badLogin", true);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");

            rd.forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/login.jsp");
        rd.forward(request,response);
    }
}
