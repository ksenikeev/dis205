package ru.itis.dis205.lab2_4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.dis205.lab2_4.component.Amount;
import ru.itis.dis205.lab2_4.component.Client;
import ru.itis.dis205.lab2_4.component.FirstBank;
import ru.itis.dis205.lab2_4.config.Config;

public class Main {
    public static void main(String[] args) {
        // Создание контекста
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        // Получение экземпляра бина
        Amount client1 = (Amount) context.getBean("amount");
        System.out.println("Current amount: " + client1.getAmount() + " in bank:" + client1.getBank());
        client1.setAmount(500d);

        Amount client2 = (Amount) context.getBean("amount");
        System.out.println(client2.equals(client1));
        System.out.println("Current amount: " + client2.getAmount() + " in bank:" + client1.getBank());

        FirstBank bank = (FirstBank) context.getBean("bank");
        System.out.println(bank);

        Client client = (Client) context.getBean("client");
        System.out.println(client.getName());

    }
}
