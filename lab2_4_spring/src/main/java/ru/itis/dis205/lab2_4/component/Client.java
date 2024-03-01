package ru.itis.dis205.lab2_4.component;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Client {
    private String name;
    private List<Amount> amounts;

    public Client() {
        this.name = "test client";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Amount> getAmounts() {
        return amounts;
    }

    public void setAmounts(List<Amount> amounts) {
        this.amounts = amounts;
    }
}
