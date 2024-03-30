package ru.itis.dis205.lab2_7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.dis205.lab2_7.app.Main;
import ru.itis.dis205.lab2_7.config.Config;
import ru.itis.dis205.lab2_7.model.Merch;
import ru.itis.dis205.lab2_7.model.Store;
import ru.itis.dis205.lab2_7.repository.MerchRepository;
import ru.itis.dis205.lab2_7.repository.StoreRepository;
import ru.itis.dis205.lab2_7.repository.StoreRepositoryImpl;
import ru.itis.dis205.lab2_7.service.StoreService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        StoreService service = (StoreService) context.getBean("storeService");
        //service.addStore();

        Store store = service.findById(9l);

        store.getMerches().forEach(s-> System.out.println(s.getName()));

    }
}
