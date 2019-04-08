package com.checklisttarasgl.servlets;

import com.checklisttarasgl.classes.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "AddEventServlet")
public class AddEventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("");
        String eventName = request.getParameter("name");
        String eventDescription = request.getParameter("description");
        int userID = (int)request.getSession(false).getAttribute("userID");
        try
        {
            Connection conn = DBConnection.getConnection();
            String sqlQuery = " INSERT INTO [Checklist].[dbo].[Event]([Name],[Text],[isDone])" +
                    "VALUES(?,?,0); " +
                    "INSERT INTO [Checklist].[dbo].[UserEvent] ([userID],[eventID]) " +
                    "VALUES(?,Scope_Identity()); ";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1,eventName);
            preparedStatement.setString(2,eventDescription);
            preparedStatement.setInt(3,userID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
            System.out.println("updated row");
        }
        catch (SQLException ex){
            ex.printStackTrace();
            response.setContentType("text/plain");
            response.getWriter().write("error");
            return;
        }

        response.setContentType("text/plain");
        response.getWriter().write("success");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
