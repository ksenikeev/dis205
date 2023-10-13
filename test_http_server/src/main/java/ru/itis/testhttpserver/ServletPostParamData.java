package ru.itis.testhttpserver;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/postparam")
public class ServletPostParamData extends HttpServlet {


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter writer = response.getWriter();
        writer.println("ContentType: " + request.getContentType());
        writer.println("ContentLength: " + request.getContentLength());

        Map<String, String[]> params = request.getParameterMap();

        if (params != null) {
           // params.entrySet();
        }

        writer.println();
    }
}
