package ru.itis.testhttpserver;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getinfojson")
public class ServletRequestInfoAsJson extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");

        PrintWriter writer = response.getWriter();

        String json = "{\"remote_port\":\"" + request.getRemotePort() + "\","
            + "\"remote_host\":\"" + request.getRemoteHost() + "\","
                + "\"remote_addr\":\"" + request.getRemoteAddr() + "\","
                + "\"content_type\":\"" + request.getContentType() + "\"}";

        writer.print(json);
    }
}
