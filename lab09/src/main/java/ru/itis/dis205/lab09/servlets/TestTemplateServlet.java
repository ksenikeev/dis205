package ru.itis.dis205.lab09.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.dis205.lab09.template.TemplateLib;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@WebServlet("*.thtml")
public class TestTemplateServlet extends HttpServlet {

    private TemplateLib templateLib;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

/*
        templateLib = new TemplateLib();
        Map<String,String> params = new HashMap<>();
        params.put("errormessage",   "Неверный пароль" );

        System.out.println(request.getServletPath().substring(1));

        String html = templateLib.makeHTML(request.getServletPath().substring(1), params);


        Writer writer = response.getWriter();
        writer.write(html);
*/

        request.setAttribute("errormessage","Неверный пароль");
        request.getRequestDispatcher("templates/index_template.thtml").forward(request, response);

    }
}
