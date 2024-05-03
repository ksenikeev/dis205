package ru.itis.dis205.lab2_12.web.model.transport;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter
@Entity
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Transient
    private Geometry geometry;
    @ManyToOne(cascade = CascadeType.ALL)
    private EntityGeometry egeometry;
    @ManyToOne(cascade = CascadeType.ALL)
    private FeatureProperties properties;
}
