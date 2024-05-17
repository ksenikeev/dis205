package ru.itis.dis205.lab2_14.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.dis205.lab2_14.model.User;
import ru.itis.dis205.lab2_14.security.UserDetailImpl;
import ru.itis.dis205.lab2_14.security.UserDetailsServiseImpl;
import ru.itis.dis205.lab2_14.service.UserService;

@Controller
public class SecurityController {

    private static Logger log = LoggerFactory.getLogger(SecurityController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiseImpl userDetailsServise;

    @Autowired
    private AuthenticationManager authenticationManager;

    private HttpSessionSecurityContextRepository contextRepository = new HttpSessionSecurityContextRepository();

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginPage(HttpServletRequest request, Model model) {
        model.addAttribute("app_path", request.getContextPath());
        return "login";
    }

/*
    @PostMapping("/usercheck")
    String register(HttpServletRequest request, HttpServletResponse response, Model model) {

        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String encodedPassword = passwordEncoder.encode(request.getParameter("password"));

        try {
            User user = userService.findUserByUsername(username);

            UserDetailImpl userDetail = new UserDetailImpl(user);
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userDetail, password);
            Authentication authentication = authenticationManager.authenticate(authRequest);

            SecurityContextHolder.getContext().setAuthentication(authentication);
            SecurityContext securityContext = SecurityContextHolder.getContext();

            contextRepository.saveContext(securityContext, request, response);
            log.warn("context : " + SecurityContextHolder.getContext());
            return "redirect:";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
            return "login?error";
        }
    }
*/

}
