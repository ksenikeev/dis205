package ru.itis.dis205.lab2_8.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String paspnum;
}
