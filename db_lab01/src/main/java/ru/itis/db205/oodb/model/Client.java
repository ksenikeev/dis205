package ru.itis.db205.oodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
public class Client {
    private String name;
    private Bank bank;
    private String passport;


}
