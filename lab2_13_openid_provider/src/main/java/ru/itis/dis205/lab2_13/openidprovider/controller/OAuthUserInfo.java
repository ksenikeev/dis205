package ru.itis.dis205.lab2_13.openidprovider.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dis205.lab2_13.openidprovider.dto.UserDto;
import ru.itis.dis205.lab2_13.openidprovider.model.User;
import ru.itis.dis205.lab2_13.openidprovider.security.OAuthService;
import ru.itis.dis205.lab2_13.openidprovider.service.UserService;

import java.util.Optional;

@RestController
public class OAuthUserInfo {

    @Autowired
    private OAuthService oAuthService;
    @Autowired
    private UserService userService;

    @GetMapping("/oauthtoken")
    public String makeTokenForUserInfoRequest(HttpServletRequest request) {

        String userId = request.getParameter("userid");
        String secret = request.getParameter("secret");
        Long providerCode = oAuthService.oAuthRequest.get(Long.parseLong(userId));

        String token = JWT.create()
                .withSubject(String.valueOf(providerCode))
                .withClaim("id", userId)
                .sign(Algorithm.HMAC256(secret));

        return token;
    }

    @GetMapping("/oautuserinfo")
    public UserDto getUserInfo(HttpServletRequest request,
                               @RequestParam("token") String token) {

        try {
            DecodedJWT decodedJWT = JWT.decode(token);

            String userId = decodedJWT.getClaim("id").asString();
            Optional<User> user = userService.findById(Long.parseLong(userId));

            return new UserDto(user.get());


        } catch (JWTVerificationException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}
