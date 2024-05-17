package ru.itis.dis205.lab2_14.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.dis205.lab2_14.model.User;
import ru.itis.dis205.lab2_14.security.UserDetailImpl;

@Controller
public class UserCabinetController {
    private Logger log = LoggerFactory.getLogger(UserCabinetController.class);

    @GetMapping("/cabinet")
    public String index(HttpServletRequest request, Authentication authentication, Model model) {
        model.addAttribute("app_path", request.getContextPath());

        User user = ((UserDetailImpl) authentication.getPrincipal()).getUser();

        model.addAttribute("email", user.getEmail());

        String avatarPath =
                (user.getUserInfo() != null && user.getUserInfo().getAvatar() != null) ?
                   "/imgstore/" +
                           user.getUserInfo().getAvatar().getPath() +
                           user.getUserInfo().getAvatar().getFileName()
                        : "/static/img/avatar_default.svg";
        model.addAttribute("avatar", avatarPath);

        return "cabinet";
    }
}
