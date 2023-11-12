package ru.itis.dis205.lab10.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.itis.dis205.lab10.model.Client;
import ru.itis.dis205.lab10.service.ClientService;
import java.io.IOException;

@WebServlet("/usercheck")
public class UsercheckServlet extends HttpServlet {

    private ClientService service = new ClientService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Client client = service.findByUserName(username);

        if ( client != null && client.getPassword().equals(password)) {

            // Создаем сессию
            HttpSession session = request.getSession();

            session.setAttribute("clientname", client.getName());
            session.setAttribute("clientid", client.getId());

            response.sendRedirect("/lab10/");

        } else {
            // Атрибуты: запрос, сессия, контекст
            request.setAttribute("message", "Неверный пароль или логин");
            request.getRequestDispatcher("login.ftl").forward(request, response);
        }
    }
}
