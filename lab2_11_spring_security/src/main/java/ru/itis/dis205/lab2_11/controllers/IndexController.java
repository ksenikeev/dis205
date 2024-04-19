package ru.itis.dis205.lab2_11.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.dis205.lab2_11.security.UserDetailImpl;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        UserDetailImpl userDetails =
                (UserDetailImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("user", userDetails.getUsername());

        return "index";
    }
}
