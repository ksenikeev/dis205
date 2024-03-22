package ru.itis.dis205.lab2_6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.dis205.lab2_6.config.Config;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        MainClass mainClass = (MainClass) context.getBean("mainClass");
        mainClass.run();

    }
}
