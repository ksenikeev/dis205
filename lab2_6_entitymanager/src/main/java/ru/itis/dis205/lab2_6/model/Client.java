package ru.itis.dis205.lab2_6.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter@Setter
@Entity
public class Client extends Person {
    private String phone;
}
