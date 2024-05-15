package ru.itis.dis205.lab2_13.openidprovider.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.dis205.lab2_13.openidprovider.dto.DeveloperDto;
import ru.itis.dis205.lab2_13.openidprovider.model.Developer;
import ru.itis.dis205.lab2_13.openidprovider.service.DeveloperService;

@Controller
public class RegisterDeveloperController {

    @Value("${jwt.secret}")
    private String SECRET;

    @Autowired
    private DeveloperService service;

    @GetMapping("/developer")
    public String developerRegistrationPage(HttpServletRequest request, Model model) {
        model.addAttribute("apppath",request.getContextPath());
        return "developer";
    }

    @PostMapping("/developer/save")
    public String developerSave(HttpServletRequest request, Model model, DeveloperDto dto) {
        model.addAttribute("apppath",request.getContextPath());

        Developer developer = Developer.builder()
                .appname(dto.getAppname())
                .homepage(dto.getHomepage())
                .callbackurl(dto.getCallbackurl())
                .appdecript(dto.getAppdecript())
                .build();

        try {
            developer = service.save(developer);

            String token = JWT.create()
                    .withSubject(developer.getId().toString())
                    .withClaim("id", developer.getId())
                    .withClaim("callbackurl", developer.getCallbackurl())
                    .sign(Algorithm.HMAC256(SECRET));

            model.addAttribute("message","Регистрация прошла успешно");
            model.addAttribute("token",token);
        } catch (Exception e) {
            model.addAttribute("message","Проблемы с регистрацией. " + e.getMessage());
        }
        return "developer_success";
    }
}
