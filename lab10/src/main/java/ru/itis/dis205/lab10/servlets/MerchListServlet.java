package ru.itis.dis205.lab10.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.itis.dis205.lab10.model.Merch;
import ru.itis.dis205.lab10.service.MerchService;

import java.io.IOException;
import java.util.List;

/**
 * Сервлет, обрабатывающий запросы, адресованные к корню сайта
 * сервлет получает из сессии (которая приходит в сервлет как часть запроса) данные клиента
 * и передает их в шаблонизатор через атрибуты запроса
 *
 * ниже приведен фрагмент файла web.xml (дескриптора развертывания веб-приложения), это альтернатива
 * аннотации @WebServlet("/"). Можно использовать что-то одно
 *
 * web.xml:
 *     <servlet>
 *         <servlet-name>Index Servlet</servlet-name>
 *         <servlet-class>ru.itis.dis205.lab10.servlets.IndexServlet</servlet-class>
 *     </servlet>
 *     <servlet-mapping>
 *         <servlet-name>Index Servlet</servlet-name>
 *         <url-pattern>/</url-pattern>
 *     </servlet-mapping>
 */
@WebServlet("/merchlist")
public class MerchListServlet extends HttpServlet {

    private MerchService service = new MerchService();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Запрашиваем сессию, запрещая создавать новую в случае отсутствия
        // т.к. на этот момент клиент уже должен был успешно пройти аутентификацию (все запросы для проверки перехватывает фильтр),
        // то сессия должна существовать (по логике КОНКРЕТНО ЭТОГО приложения)
        HttpSession session = request.getSession(false);
        String clientName = (String)session.getAttribute("clientname");
        Long clientId = (Long)session.getAttribute("clientid");

        // кладем в атрибуты запроса данные, эти атрибуты будут обработаны шаблонизатором
        request.setAttribute("clientid", clientId);
        request.setAttribute("clientname", clientName);

        List<Merch> merchlist = service.findAll();
        request.setAttribute("merchs", merchlist);

        //Передаем управление диспетчеру , говоря, что требуется обработать сервлет по пути
        // merchlist.ftl
        request.getRequestDispatcher("merchlist.ftl").forward(request, response);
    }
}
