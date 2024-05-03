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
    @ManyToOne(cascade = CascadeType.ALL)
    private Properties properties;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Feature> features;
}
