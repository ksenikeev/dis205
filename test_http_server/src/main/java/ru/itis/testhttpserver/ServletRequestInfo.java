package ru.itis.testhttpserver;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getinfo")
public class ServletRequestInfo extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println(request.getRemotePort());
        writer.println(request.getRemoteHost());
        writer.println(request.getRemoteAddr());
        writer.println(request.getProtocol());
        writer.println(request.getLocalPort());
        writer.println(request.getScheme());
        writer.println(request.getLocalAddr());
        writer.println(request.getContentType());
        writer.println(request.getRealPath(""));
    }
}
