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

@WebServlet(name = "DeleteEventServlet")
public class DeleteEventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int eventID = Integer.parseInt(request.getParameter("eventID"));
        int userID = (int) request.getSession(false).getAttribute("userID");
        String sqlQuery = "DECLARE @EventToDelete TABLE (EventId int, UserEventID int )" + //declaring reserve table
                "INSERT INTO @EventToDelete " +  //inserting into reserve table events that are going to be deleted
                "SELECT EventID, UserEvent.id FROM Event JOIN UserEvent " +
                "ON Event.ID = UserEvent.eventID " +
                "Where Event.ID = ? AND UserEvent.userID = ? " +
                "DELETE FROM UserEvent " +
                "WHERE id IN (SELECT UserEventId FROM @EventToDelete) " +
                "DELETE FROM Event " +
                "WHERE id IN (SELECT EventId FROM @EventToDelete) ";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, eventID);
            preparedStatement.setInt(2, userID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
        } catch (SQLException ex) {
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
