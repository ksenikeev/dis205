package ru.itis.dis205.lab2_6.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter@Setter
@Entity
public class Driver extends Person {
    private Integer experience;
}
