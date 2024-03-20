package ru.itis.dis205.lab2_6.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Car {
    @Id
    private Long id;
    private String carNumber;
    private String carBrand;
    @Enumerated(EnumType.STRING)
    private CarColor color;
}
