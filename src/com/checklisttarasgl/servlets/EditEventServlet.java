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

@WebServlet(name = "EditEventServlet")
public class EditEventServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventID = Integer.parseInt(request.getParameter("eventID"));
        boolean isDone = Boolean.parseBoolean(request.getParameter("isDone"));
        int userID = (int) request.getSession(false).getAttribute("userID");
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        String sqlQuery = "UPDATE Event " +
                "SET name = ?, text = ?,  isDone = ? " +
                "WHERE id IN(SELECT Event.id FROM Event JOIN UserEvent " +
                "ON Event.ID = UserEvent.eventID " +
                "Where Event.ID = ? AND UserEvent.userID = ?);";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, description);
            preparedStatement.setBoolean(3, isDone);
            preparedStatement.setInt(4, eventID);
            preparedStatement.setInt(5, userID);
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
