package ru.itis.dis205.lab2_12.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Scanner;

public class MainVerifyToken {
    private static final String SECRET = "123efeas134";

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //String token = scanner.nextLine();
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMCIsInJvbGUiOiJVU0VSIiwic3RhdGUiOiJBQ1RJVkUiLCJlbWFpbCI6ImtzZW5pa2VldkBrcGZ1LnJ1In0.xHn_3KWs3rLGF8rxAfZusLBdZ_PuKbW4ehB6dQOAD9g";
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(SECRET))
                    .build()
                    .verify(token);

            System.out.println(decodedJWT.getClaim("role"));
            System.out.println(decodedJWT.getClaim("state"));
            System.out.println(decodedJWT.getClaim("email"));
        } catch (JWTVerificationException e) {
            System.err.println(e.getMessage());
        }
    }
}
