package ru.itis.dis205.lab08.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/template")
public class TemplateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        String html = ""; // load file template to string
        // replace ${param_name} to values

        URL is = this.getClass().getClassLoader().getResource("/templates/index_template.html");
        System.out.println(is);
        html = Files.readString(Paths.get(is.getPath()));

        System.out.println(html);
        // send string to client
        Writer writer = response.getWriter();
        writer.write(html);
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response) {

    }
}
