package ru.itis.dis205.lab2_15.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("app_path", request.getContextPath());
        return "index";
    }

    @GetMapping("/services")
    public String services(HttpServletRequest request, Model model) {
        model.addAttribute("app_path", request.getContextPath());
        return "services";
    }

    @GetMapping("/masters")
    public String masters(HttpServletRequest request, Model model) {
        model.addAttribute("app_path", request.getContextPath());
        return "masters";
    }

    @GetMapping("/cabinet")
    public String cabinet(HttpServletRequest request, Model model) {
        model.addAttribute("app_path", request.getContextPath());
        return "cabinet";
    }

}
