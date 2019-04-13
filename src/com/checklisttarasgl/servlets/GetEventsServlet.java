package com.checklisttarasgl.servlets;

import com.checklisttarasgl.classes.DBConnection;
import com.checklisttarasgl.classes.Event;

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
import java.util.ArrayList;

@WebServlet(name = "GetEventsServlet")
public class GetEventsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int userId = (int) session.getAttribute("userID");

        try {
            Connection conn = DBConnection.getConnection();
            String sqlQuery = "SELECT [Checklist].[dbo].[Event].[id] AS id,[Checklist].[dbo].[Event].[Name] AS name, " +
                    "[Checklist].[dbo].[Event].[text] as text, [Checklist].[dbo].[Event].[isDone] AS isDone " +
                    "FROM [Checklist].[dbo].[User] JOIN [Checklist].[dbo].[UserEvent] ON " +
                    "[Checklist].[dbo].[User].[id] = [Checklist].[dbo].[UserEvent].[userID]" +
                    "JOIN [Checklist].[dbo].Event ON [Checklist].[dbo].[UserEvent].[eventID] = [Checklist].[dbo].[Event].[id]" +
                    " WHERE [Checklist].[dbo].[User].[id] = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, userId);

            ResultSet res = preparedStatement.executeQuery();
            ArrayList<Event> events = new ArrayList<>();
            while (res.next()) {
                int ev_id = res.getInt("id");
                String ev_name = res.getString("name");
                String ev_text = res.getString("text");
                boolean ev_isDone = res.getBoolean("isDone");
                System.out.println(ev_name + ev_text);
                events.add(new Event(ev_id, ev_name, ev_text, ev_isDone));
            }
            request.setAttribute("events", events);

            preparedStatement.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("gettingEvents");
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/events.jsp");
        rd.forward(request, response);
    }
}
