package ru.itis.db205.oodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
public class Account {
    private Client client;
    private String currency;
    private Float balance;
    private String accountNumber;
}
