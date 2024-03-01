package ru.itis.dis205.lab2_4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.itis.dis205.lab2_4.component.Amount;
import ru.itis.dis205.lab2_4.component.Bank;
import ru.itis.dis205.lab2_4.component.ClientAmount;
import ru.itis.dis205.lab2_4.component.FirstBank;

// Описываем контекст через класс-конфигурацию
@Configuration
@ComponentScan("ru.itis.dis205.lab2_4.component")
public class Config {

    @Bean
    public Bank bank() {
        FirstBank bank = new FirstBank("Банк N 1");
        bank.setBranchOffice("Офис 2");
        return bank;
    }

    @Bean
    @Scope("prototype")
    public Amount amount() {
        ClientAmount amount = new ClientAmount(5000d);
        amount.setBank(bank());
        return amount;
    }

}
