package ru.itis.dis205.lab2_6.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter@Setter
@Entity
public class Trip {
    @Id
    @SequenceGenerator(name = "trip_gen", sequenceName = "trip_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "trip_gen")
    private Long id;
    //@Temporal(TemporalType.TIMESTAMP) для типа данных Date
    private LocalDateTime startTime;
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime finishTime;
    @ManyToOne(cascade = CascadeType.ALL)
    private Car car;
    @ManyToOne(cascade = CascadeType.ALL)
    private Passenger passenger;
    private String startPoint;
    private String finishPoint;
    @ManyToOne(cascade = CascadeType.ALL)
    private Driver driver;
}
