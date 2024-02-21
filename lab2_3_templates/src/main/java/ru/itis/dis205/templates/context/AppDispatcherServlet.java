package ru.itis.dis205.templates.context;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.lang.reflect.Method;
import java.util.Map;

public class AppDispatcherServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) {

        // 1. Определить метод
        // 2. Определить путь
        // 3. Взять из контроллера метод, соответвующий пути и методу запроса

        Map<String, Method> postMethods;
        Map<String, Method> getMethods;

        // 4. Выполнить, передав аргументы


    }

}
