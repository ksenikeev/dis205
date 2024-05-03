package ru.itis.dis205.lab2_12.web.model.transport;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@Entity
@Table(name = "geometry")
public class EntityGeometry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String type;
    @OneToMany(cascade = CascadeType.ALL)
    List<Coordinates> coordinates;
}
