package ru.itis.dis205.lab10.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.dis205.lab10.model.Bank;
import ru.itis.dis205.lab10.service.BankService;

import java.io.IOException;
import java.util.List;

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

    private BankService service = new BankService();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Bank> lst = service.findAll();

        // Атрибуты: запрос, сессия, контекст
        request.setAttribute("hello", "Hello for freemarker!");

        //Передаем управление диспетчеру , говоря, что требуется обработать сервлет по пути
        // index.ftlxxx
        request.getRequestDispatcher("index.ftlxxx").forward(request, response);
    }
}
