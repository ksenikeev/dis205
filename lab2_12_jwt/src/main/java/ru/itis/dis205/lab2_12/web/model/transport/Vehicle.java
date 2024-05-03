package ru.itis.dis205.lab2_12.web.model.transport;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter@Getter
public class Vehicle {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @ManyToOne
    private Properties properties;
    @OneToMany
    private List<Feature> features;
}
