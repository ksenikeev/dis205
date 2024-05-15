package ru.itis.dis205.lab2_13.openidprovider.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        System.out.println("/login controller");
        return "login";
    }

    @GetMapping("/loginoauth")
    public String loginOAuth(HttpServletRequest request, Model model) {
        model.addAttribute("developerid", request.getParameter("oauth"));
        return "loginoauth";
    }
}
