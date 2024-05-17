package ru.itis.dis205.lab2_14.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("app_path", request.getContextPath());
        return "index";
    }
}
