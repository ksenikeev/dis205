package ru.itis.dis205.lab11.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Merch {
    private String articul;
    private String name;
    private Float price;

    public Merch(String articul, String name, Float price) {
        this.articul = articul;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "\"articul\":\"" + articul + "\"," +
                "\"name\":\"" + name + "\"," +
                "\"price\":" + price + "}";
    }
}
