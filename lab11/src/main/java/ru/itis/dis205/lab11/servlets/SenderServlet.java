package ru.itis.dis205.lab11.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 */
@WebServlet("/send")
public class SenderServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("sending message");
        String message = request.getParameter("message");
        WebSocketConnector connector = WebSocketConnector.endPoints.get("Kamil");
        if (connector != null) {
            System.out.println(connector.getUsername());
            connector.sendMessage(message);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }
}
