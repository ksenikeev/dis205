package ru.itis.dis205.lab09.servlets;

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
public class TemplateLibServlet extends HttpServlet {

    private TemplateLib templateLib;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer i;

        templateLib = new TemplateLib();
        Map<String,String> params = new HashMap<>();

        request.getAttributeNames()
        for ...
        params.put("errormessage",   "Неверный пароль" );

        String html = templateLib.makeHTML("templates/index_template.thtml", params);


        Writer writer = response.getWriter();
        writer.write(html);
    }
}
