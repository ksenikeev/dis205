package ru.itis.dis205.lab2_8.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Address {
    @Id
    private Long id;
    private String postalIndex;
    private String fullpath;
}
