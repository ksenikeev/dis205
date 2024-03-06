package ru.itis.dis205.lab2_5.model;

import lombok.Getter;
import lombok.Setter;
import ru.itis.dis205.lab2_5.annotation.Entity;

@Getter
@Setter
@Entity
public class Country {
    private Integer id;
    private String name;
}
