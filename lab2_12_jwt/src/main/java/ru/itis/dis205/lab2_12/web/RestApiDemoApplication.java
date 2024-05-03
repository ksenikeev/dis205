package ru.itis.dis205.lab2_12.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class RestApiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RestApiDemoApplication.class, args);
    }
}
