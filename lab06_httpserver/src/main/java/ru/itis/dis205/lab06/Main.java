package ru.itis.dis205.lab06;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String, ResourceHandler> handlers = new HashMap<>();
    public static void main(String[] args) {

        handlers.put("/index", new IndexHandler());
        handlers.put("/json", new JsonHandler());


        String resourceName = "/index2";
        ResourceHandler handler = handlers.get(resourceName);

        String response = "";

        if (handler != null) {
            response = handler.handle(null);
        } else {
            response = new Error404Handler().handle(null);
        }

        System.out.println(response);
    }
}
