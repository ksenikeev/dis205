package ru.itis.dis205.lab2_12.web.model.transport;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonProperty("VehicleMetaData")
    private VehicleMetaData vehicleMetaData;
}