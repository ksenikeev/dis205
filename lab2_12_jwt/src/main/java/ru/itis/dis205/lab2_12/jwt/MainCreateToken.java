package ru.itis.dis205.lab2_12.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import ru.itis.dis205.lab2_12.web.model.RoleType;
import ru.itis.dis205.lab2_12.web.model.User;

public class MainCreateToken {

    private static final String SECRET = "123efeas134";

    // https://jwt.io/

    public static void main(String[] args) {
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

        System.out.println(token);
//eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwicm9sZSI6IkFETUlOIiwibmFtZSI6IkthbWlsIiwiaWQiOjEsImVtYWlsIjoia3NlbmlrZWV2QGtwZnUucnUifQ.nz5rlV18h_AwapGfE28chGCzp_E2lX5xHPOOMIo1ccc
    }
}
