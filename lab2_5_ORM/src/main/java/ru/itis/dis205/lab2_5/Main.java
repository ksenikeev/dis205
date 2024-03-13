package ru.itis.dis205.lab2_5;

import org.flywaydb.core.Flyway;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.dis205.lab2_5.component.MisicRepository;
import ru.itis.dis205.lab2_5.config.Config;

public class Main {
    public static void main(String[] args) {
        // Создание контекста
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

/*
        Flyway flyway = (Flyway) context.getBean("flyway") ;
        flyway.migrate();
*/

        MisicRepository repository = (MisicRepository) context.getBean("misicRepository");
        repository.printAllTracks();

    }
}
