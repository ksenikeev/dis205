package ru.itis.dis205.embededserver;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Пример встраивания контейнера сервлетов Tomcat в приложение
 * Запускаем на порту 8090
 * http://localhost:8090/show/info
 */
public class Main {
    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        Connector conn = new Connector();
        conn.setPort(8090);
        tomcat.setConnector(conn);
        String contextPath = "";
        String docBase = new File(".").getAbsolutePath();
        Context tomcatContext = tomcat.addContext(contextPath, docBase);

        /*
            Создаем сервлет, лучше разместить этот код в отдельном файле
         */
        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void service(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
                resp.setContentType("text/html; charset=utf-8");
                PrintWriter writer = resp.getWriter();
                writer.println("<html><head><meta charset='utf-8'/><title>Embeded Tomcat</title></head><body>");
                writer.println("<h1>Мы встроили Tomcat в свое приложение!</h1>");

                writer.println("<div>Метод: " + req.getMethod() + "</div>");
                writer.println("<div>Ресурс: " + req.getPathInfo() + "</div>");
                writer.println("</body></html>");
            }
        };

        /*
            Динамически подключаем севлет
         */
        String servletName = "dispatcherServlet"; // любое уникальное имя
        tomcat.addServlet(contextPath, servletName, servlet);
        // Указываем имя ресурса и сервлет, который этот ресурс будет обрабатывать
        // (по пути "/*" наш сервлет будет перехватывать все запросы)
        tomcatContext.addServletMappingDecoded("/*", servletName);

        try {
            tomcat.start();
            tomcat.getServer().await();

            /*
                tomcat.stop()
                tomcat.destroy()
             */
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
    }
}
