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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        if(username.isEmpty()||password.isEmpty()||confirmPassword.isEmpty()){
            request.setAttribute("fieldIsEmpty", true);
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/register.jsp");
            rd.include(request, response);
        } else{
            if(!confirmPassword.equals(password)){
                request.setAttribute("passwordIsNotConfirmed", true);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/register.jsp");
                rd.include(request, response);
            } else {
                //check if there is already existing username
                try {
                    String sqlGetCount = "SELECT COUNT(*) AS usernameCount FROM [User] WHERE username = ?";
                    Connection conn = DBConnection.getConnection();
                    PreparedStatement selectCountPrepStat = conn.prepareStatement(sqlGetCount);
                    selectCountPrepStat.setString(1, username);
                    ResultSet countResultSet= selectCountPrepStat.executeQuery();
                    countResultSet.next();
                    int countUsers = countResultSet.getInt("usernameCount");
                    if(countUsers !=0){
                        //user already exists, redirect to login again
                        request.setAttribute("userAlreadyExists", true);
                        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/register.jsp");
                        rd.include(request, response);
                    } else {
                        //username is free, register
                        try {
                            String sqlRegisterUser = "INSERT INTO [User](username, password) " +
                                    "VALUES (?,?) ";
                            PreparedStatement addUserPrepStat = conn.prepareStatement(sqlRegisterUser);
                            addUserPrepStat.setString(1,username);
                            addUserPrepStat.setString(2,password);
                            int usersAdded = addUserPrepStat.executeUpdate();
                            if(usersAdded == 1){
                                //user is registered. Log him in
                                String sqlSelectUserId = "SELECT id FROM [User] WHERE username = ?";
                                PreparedStatement getUserIdPrepStat = conn.prepareStatement(sqlSelectUserId);
                                getUserIdPrepStat.setString(1, username);
                                ResultSet userIdSet = getUserIdPrepStat.executeQuery();
                                userIdSet.next();
                                int userId = userIdSet.getInt(1);
                                HttpSession session = request.getSession();
                                session.setAttribute("userID", userId);
                                session.setAttribute("username", username);
                                //setting session to expiry in 10 mins
                                session.setMaxInactiveInterval(10*60);

                                response.sendRedirect("home");
                            }
                            else {
                                //failed to register
                            }

                        } catch (SQLException ex){
                            ex.printStackTrace();
                        }
                    }

                } catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/register.jsp");
        rd.forward(request,response);
    }
}
