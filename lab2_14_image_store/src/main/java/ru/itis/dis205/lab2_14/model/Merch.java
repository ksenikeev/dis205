package ru.itis.dis205.lab2_14.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Merch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String articul;

    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    private ImageFileData image;

    private Integer count;
}
