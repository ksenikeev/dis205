package ru.itis.dis205.lab2_6.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Passenger {
    @Id
    @SequenceGenerator(name = "passenger_gen", sequenceName = "passenger_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "passenger_gen")
    private Long id;
    private String name;
    private String phone;
}
