package ru.itis.dis205.lab2_10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }

}
