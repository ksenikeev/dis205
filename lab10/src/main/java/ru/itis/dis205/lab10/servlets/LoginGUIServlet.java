package ru.itis.dis205.lab10.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginGUIServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Атрибуты: запрос, сессия, контекст
        request.setAttribute("message", "");

        //Передаем управление диспетчеру , говоря, что требуется обработать сервлет по пути
        // index.ftl
        request.getRequestDispatcher("login.ftl").forward(request, response);
    }
}
