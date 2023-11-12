package ru.itis.dis205.lab10.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * web.xml
 *     <servlet>
 *         <servlet-name>Index Servlet</servlet-name>
 *         <servlet-class>ru.itis.dis205.lab10.servlets.IndexServlet</servlet-class>
 *     </servlet>
 *     <servlet-mapping>
 *         <servlet-name>Index Servlet</servlet-name>
 *         <url-pattern>/</url-pattern>
 *     </servlet-mapping>
 */
@WebServlet("/")
public class IndexServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession(false);
        String clientName = (String)session.getAttribute("clientname");
        Long clientId = (Long)session.getAttribute("clientid");

        request.setAttribute("clientid", clientId);
        request.setAttribute("clientname", clientName);
        // Атрибуты: запрос, сессия, контекст
        request.setAttribute("hello", "Hello for freemarker!");

        //Передаем управление диспетчеру , говоря, что требуется обработать сервлет по пути
        // index.ftl
        request.getRequestDispatcher("index.ftl").forward(request, response);
    }
}
