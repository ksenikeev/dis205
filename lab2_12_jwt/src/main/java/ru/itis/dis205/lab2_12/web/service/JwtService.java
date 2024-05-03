package ru.itis.dis205.lab2_12.web.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class JwtService {

    //@Value("${jwt.secret}")
    private String SECRET="123efeas134";

    public boolean validate(String token) {
        DecodedJWT decodedJWT;
        try {
            decodedJWT = JWT.require(Algorithm.HMAC256(SECRET))
                    .build()
                    .verify(token);
            return true;
        } catch (JWTVerificationException e) {
            //throw new AuthenticationCredentialsNotFoundException("bad jwt token");
        }
        return false;
    }

}
