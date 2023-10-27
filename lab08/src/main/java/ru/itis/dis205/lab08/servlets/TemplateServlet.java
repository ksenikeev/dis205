package ru.itis.dis205.lab08.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;

@WebServlet("/template")
public class TemplateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {


        String html = ""; // load file template to string
        // replace ${param_name} to values

        // send string to client
        Writer writer = response.getWriter();
        writer.write(html);
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response) {

    }
}
