package ru.itis.dis205.lab07;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Writer;

@WebServlet("/simple")
public class SimpleServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("call init Servlet");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("call service");
        //OutputStream os = servletResponse.getOutputStream();
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        Writer writer = servletResponse.getWriter();
        writer.write("Hello!");
        writer.write(request.getMethod());
        //writer.write(request.getContentType());
        writer.write(request.getRemoteAddr());
        //writer.write(request.getParameter("id"));
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("call destroy servlet");
    }
}
