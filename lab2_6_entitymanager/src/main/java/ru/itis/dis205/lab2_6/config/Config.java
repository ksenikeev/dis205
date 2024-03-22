package ru.itis.dis205.lab2_6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Описываем контекст через класс-конфигурацию
@Configuration
@ComponentScan("ru.itis.dis205.lab2_6")
public class Config {

    @Bean
    public EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("lab2_6");
    }


}
