package ru.itis.dis205.lab2_6.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Passenger {
    @Id
    private Long id;
    private String name;
    private String phone;
}
