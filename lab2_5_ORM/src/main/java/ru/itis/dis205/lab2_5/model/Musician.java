package ru.itis.dis205.lab2_5.model;

import lombok.Getter;
import lombok.Setter;
import ru.itis.dis205.lab2_5.annotation.Entity;
import ru.itis.dis205.lab2_5.annotation.ManyToOne;

@Getter
@Setter
@Entity
public class Musician {
    private Integer id;
    private String name;
    @ManyToOne
    private Country country;
}
