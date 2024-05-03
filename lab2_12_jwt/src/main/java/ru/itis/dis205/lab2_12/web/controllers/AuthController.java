package ru.itis.dis205.lab2_12.web.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dis205.lab2_12.web.dto.AuthenticationRequest;
import ru.itis.dis205.lab2_12.web.dto.AuthenticationResponse;
import ru.itis.dis205.lab2_12.web.model.RoleType;
import ru.itis.dis205.lab2_12.web.model.User;

@RestController
public class AuthController {

    @Value("${jwt.secret}")
    private String SECRET;

    @PostMapping("/login")
    public ResponseEntity<?> authentificateByUserNameAndPassword(@RequestBody AuthenticationRequest authenticationRequest) {
        // validate user
        System.out.println("validate");
        User user = User.builder()
                .id(1L)
                .email("ksenikeev@kpfu.ru")
                .userRole(RoleType.ADMIN)
                .name("Kamil")
                .build();

        String token = JWT.create()
                .withSubject(user.getId().toString())
                .withClaim("id", user.getId())
                .withClaim("name", user.getName())
                .withClaim("role", user.getUserRole().toString())
                .withClaim("email", user.getEmail())
                .sign(Algorithm.HMAC256(SECRET));

        AuthenticationResponse authenticationResponse = new AuthenticationResponse(token,"");

        return ResponseEntity.ok(authenticationResponse);
    }
}
