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
 * Сервлет принимает данные формы со страницы  /login
 * аутентифицирует пользователя по логину и паролю
 * перенаправляет:
 *  - при успешной аутентификации на главную страницу
 *  - при ошибке в логине или пароле вновь на страницу с шаблоном login.ftl с сообщением об ошибке
 */
@WebServlet("/usercheck")
public class UsercheckServlet extends HttpServlet {

    private ClientService service = new ClientService();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("usercheck servlet");

        // извлекаем из запроса параметры формы
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // ищем в БД пользователя с указанным логином
        Client client = service.findByUserName(username);

        // если пользователь нашелся надо проверить пароль
        if ( client != null && client.getPassword().equals(password)) {

            // Создаем сессию для пользователя, в атрибутах которой сохраним его идентификаторы
            HttpSession session = request.getSession();

            // будем хранить в сессии имя клиента и его id для работы с БД
            session.setAttribute("clientname", client.getName());
            session.setAttribute("clientid", client.getId());

            // перенаправляем на главную страницу
            response.sendRedirect("/lab10/index");

        } else {
            // Формируем вновь страницу для ввода логина и пароля с сообщением об ошибке
            request.setAttribute("message", "Неверный пароль или логин");
            // передаем управление сервлету-шаблонизатору для вывода страницы
            // сервлет-шаблонизатор реагирует на расширение *.ftl (см. web.xml)
            request.getRequestDispatcher("login.ftl").forward(request, response);
        }
    }
}
