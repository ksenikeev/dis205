package ru.itis.dis205.lab2_14.imgclient;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Controller
public class WebController {
    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("app_path", request.getContextPath());
        return "index";
    }

    @GetMapping("/static/**")
    public void staticResources(HttpServletRequest request, HttpServletResponse response) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8091" + request.getServletPath()))
                .GET()
                .build();

        HttpResponse res =
                client.send(req, HttpResponse.BodyHandlers.ofByteArray());

        response.setContentLength(((byte[])res.body()).length);
        response.getOutputStream().write((byte[])res.body());
    }

}
