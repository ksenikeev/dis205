package ru.itis.dis205.lab2_13.openidprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.itis.dis205.lab2_13.openidprovider.model.User;
import ru.itis.dis205.lab2_13.openidprovider.service.UserService;

import java.io.IOException;

@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class OpenIDProviderApplication {

    public static void main(String[] args) throws IOException {

        ApplicationContext context = SpringApplication.run(OpenIDProviderApplication.class, args);

/*
        UserService service = context.getBean(UserService.class);
        User user = User.builder()
                .username("user")
                .password(new BCryptPasswordEncoder().encode("user"))
                .email("ksenikeev@mail.ru")
                .description("user one")
                .build();
        service.save(user);
*/
    }
}
