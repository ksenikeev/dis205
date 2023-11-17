package ru.itis.dis205.lab10.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Merch {
    private Long id;
    private String name;
    private String articul;
    private Double price;

    public Merch(Long id, String name, String articul, Double price) {
        this.id = id;
        this.name = name;
        this.articul = articul;
        this.price = price;
    }
}
