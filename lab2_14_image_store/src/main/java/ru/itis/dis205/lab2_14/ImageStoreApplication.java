package ru.itis.dis205.lab2_14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.itis.dis205.lab2_14.model.User;
import ru.itis.dis205.lab2_14.service.UserService;

@SpringBootApplication
public class ImageStoreApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ImageStoreApplication.class, args);


        // Create default user
/*
        User user = new User();
        user.setUsername("user");
        user.setPassword(new BCryptPasswordEncoder().encode("user"));
        user.setEmail("user@mail.ru");
        user.setDefaultRole();
        context.getBean(UserService.class).save(user);
*/

    }
}
