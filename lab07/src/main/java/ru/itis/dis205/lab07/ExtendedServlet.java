package ru.itis.dis205.lab07;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.*;

@WebServlet("/db")
public class ExtendedServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("call init Servlet");
        try {
            Class.forName("org.postgresql.Driver");

            connection =
                    DriverManager.getConnection(
                            // адрес БД , имя пользователя, пароль
                            "jdbc:postgresql://localhost:5432/bankdb", "postgres", "passwd");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer writer = resp.getWriter();

        writer.write("<!doctype html>");
        writer.write("<html lang=\"en\">");
        writer.write("<head>");
        writer.write("<meta charset=\"UTF-8\">");
        writer.write("<title>ExtendedServlet</title>");
        writer.write("</head>");
        writer.write("<body>");
        try {

            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM bank ");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                writer.write(" ** " + resultSet.getString("bik"));
                writer.write(" ** " + resultSet.getString("name"));
                writer.write("<br/>");
            }

            resultSet.close();

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        writer.write("</body>");
        writer.write("</html>");

    }

    @Override
    public void destroy() {
        System.out.println("call destroy servlet");
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
