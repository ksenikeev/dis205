package ru.itis.dis205.templates;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.dis205.annotations.Controller;
import ru.itis.dis205.annotations.GetRequest;
import ru.itis.dis205.annotations.PostRequest;

@Controller
public class AppController {

    @GetRequest(path="/app")
    public String getAppGet(HttpServletRequest request, HttpServletResponse response) {
        
        return "Hello!";
    }

    @PostRequest(path="/app")
    public String getAppPost(HttpServletRequest request, HttpServletResponse response) {
        return "Hello!";
    }

}
