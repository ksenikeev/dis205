package ru.itis.dis205.lab2_7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.dis205.lab2_7.config.Config;
import ru.itis.dis205.lab2_7.model.Merch;
import ru.itis.dis205.lab2_7.repository.MerchRepository;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        Merch merch = new Merch();
        merch.setName("Пылесос");
        merch.setPrice(5000D);

        MerchRepository repository
                = (MerchRepository) context.getBean("merchRepository");

        List<Merch> merchList = repository.findAllNative();

        merchList.forEach((m) -> System.out.println(m.getName()));

        merchList = repository.findAll();

        merchList.forEach((m) -> System.out.println(m.getName()));

        merchList = repository.findAllByName("Пылесос 1");

        merchList.forEach((m) -> System.out.println(m.getName()));
    }
}
