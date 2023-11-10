package ru.itis.dis205.lab10.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.dis205.lab10.model.Bank;
import ru.itis.dis205.lab10.service.BankService;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * put for test http://localhost:8080/lab10/htmlredirect
 */

@WebServlet("/htmlredirect")
public class HTMLRedirectServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Writer writer = response.getWriter();

        writer.write(
            "<html><meta http-equiv='Refresh' content='0; URL=http:/lab10/'></html>");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request,response);
    }

}
