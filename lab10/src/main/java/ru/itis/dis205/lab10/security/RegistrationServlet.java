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

/**
 * Сервлет принимает данные формы со страницы  /regpage
 * добавляет пользователя в систему
 * перенаправляет:
 *  - при успешном добавлении на главную страницу
 * TODO - при проблемах с данными формы вернуть на страницу регистрации
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private ClientService service = new ClientService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // извлекаем из запроса параметры формы
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // создаем нового пользователя
        Client client = new Client();
        client.setName(name);
        client.setPhoneNumber(phone);
        client.setPassword(password);
        client.setUserName(username);

        // TODO - добавить проверку на уникальность логина
        // пытаемся добавить его в БД
        client = service.save(client);

        // Создаем сессию для пользователя, в атрибутах которой сохраним его идентификаторы
        HttpSession session = request.getSession();

        // будем хранить в сессии имя клиента и его id для работы с БД
        session.setAttribute("clientname", client.getName());
        session.setAttribute("clientid", client.getId());

        // перенаправляем на главную страницу
        response.sendRedirect("/lab10/");
    }
}
