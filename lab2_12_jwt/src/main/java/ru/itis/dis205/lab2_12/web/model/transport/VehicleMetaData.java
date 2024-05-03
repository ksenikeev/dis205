package ru.itis.dis205.lab2_12.web.model.transport;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class VehicleMetaData {
    @Id
    private String id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonProperty("Transport")
    private Transport transport;
}
