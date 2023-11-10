package ru.itis.dis205.lab10.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.itis.dis205.lab10.model.Bank;
import ru.itis.dis205.lab10.service.BankService;

import java.io.IOException;
import java.util.List;

@WebServlet("/usercheck")
public class UsercheckServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "admin".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.sendRedirect("/lab10/");

        } else {
            // Атрибуты: запрос, сессия, контекст
            request.setAttribute("message", "Неверный пароль или логин");
            request.getRequestDispatcher("login.ftlxxx").forward(request, response);
        }
    }
}
