package ru.itis.dis205.templates.components;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.dis205.templates.annotations.Controller;
import ru.itis.dis205.templates.annotations.GetRequest;
import ru.itis.dis205.templates.annotations.PostRequest;

@Controller
public class AppController {

    @GetRequest(path="/appget")
    public String getAppGet(HttpServletRequest request, HttpServletResponse response) {
        
        return "Hello!";
    }

    @PostRequest(path="/apppost")
    public String getAppPost(HttpServletRequest request, HttpServletResponse response) {

        return "Hello!";
    }

}
