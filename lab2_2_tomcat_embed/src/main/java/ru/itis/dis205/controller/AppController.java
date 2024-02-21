package ru.itis.dis205.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.dis205.annotations.Controller;
import ru.itis.dis205.annotations.GetRequest;
import ru.itis.dis205.annotations.PostRequest;

import java.util.Map;

@Controller
public class AppController {

    @GetRequest(path="/app")
    public String getAppGet(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
        model.put("message1","Hello!");
        return "index.ftlh";
    }

    @PostRequest(path="/app")
    public String getAppPost(Map<String, Object> model,HttpServletRequest request, HttpServletResponse response) {
        model.put("message1","Hello!");
        return "index.ftlh";
    }

}
