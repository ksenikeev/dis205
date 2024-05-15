package ru.itis.dis205.lab2_13.openidprovider.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.dis205.lab2_13.openidprovider.dto.UserLoginDto;
import ru.itis.dis205.lab2_13.openidprovider.model.Developer;
import ru.itis.dis205.lab2_13.openidprovider.model.User;
import ru.itis.dis205.lab2_13.openidprovider.security.OAuthService;
import ru.itis.dis205.lab2_13.openidprovider.service.DeveloperService;
import ru.itis.dis205.lab2_13.openidprovider.service.UserService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Controller
public class UserCheckController {

    @Autowired
    private OAuthService oAuthService;
    @Autowired
    private DeveloperService developerService;
    @Autowired
    private UserService service;

    @PostMapping("/oauthusercheck")
    public String usercheckOAuth(HttpServletRequest request, HttpServletResponse resp,
                            Model model, UserLoginDto dto) throws URISyntaxException, IOException, InterruptedException {
        System.out.println("oauthusercheck");
            Optional<Developer> developer =
                    developerService.findById(dto.getDeveloperid());
            User user = service.findByUsername(dto.getUsername());

        System.out.println(developer.get().getCallbackurl() +
                "?userid=" + user.getId());
        oAuthService.oAuthRequest.put(user.getId(), developer.get().getId());
        HttpRequest httpRequest = HttpRequest
                .newBuilder(new URI(developer.get().getCallbackurl() +
                        "?userid=" + user.getId())).build();
        HttpResponse<String> oauthResp = HttpClient.newHttpClient().send(httpRequest
                , HttpResponse.BodyHandlers.ofString());

        System.out.println(oauthResp);
        //SecurityContextPersistenceFilter f;
        return "/";
    }


    @PostMapping("/usercheck")
    public String usercheck(HttpServletRequest request, HttpServletResponse resp,
                            Model model, UserLoginDto dto) {
        System.out.println("usercheck");
        try {
            request.login(dto.getUsername(), dto.getPassword());
            HttpSessionSecurityContextRepository r;
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "/";
    }
}
