package ru.itis.dis205.lab10.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
public class Bascket {
    private Long id;
    private Merch merch;
    private Client client;
    private Date purchaseDate;
}
