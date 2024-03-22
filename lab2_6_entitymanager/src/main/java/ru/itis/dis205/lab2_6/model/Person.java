package ru.itis.dis205.lab2_6.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.InheritanceType.JOINED;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Getter@Setter
@Entity
@Inheritance(strategy = SINGLE_TABLE)
public abstract class Person {
    @Id
    @SequenceGenerator(name = "driver_gen", sequenceName = "driver_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "driver_gen")
    private Long id;
    private String name;
}
