package ru.itis.dis205.lab2_13.openidprovider.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class OAuthServiceController {

    @GetMapping("/oauth")
    public String oauthPoint(HttpServletRequest request, Model model) {


        return "";
    }

}
