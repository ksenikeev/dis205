package ru.itis.dis205.templates.embededserver;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class DispatcherServlet extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><meta charset='utf-8'/><title>Embeded Tomcat</title></head><body>");
        writer.println("<h1>Мы встроили Tomcat в свое приложение!</h1>");

        writer.println("<div>Метод: " + req.getMethod() + "</div>");
        writer.println("<div>Ресурс: " + req.getPathInfo() + "</div>");
        writer.println("</body></html>");

    }

}
