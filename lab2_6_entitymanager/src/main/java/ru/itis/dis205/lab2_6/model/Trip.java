package ru.itis.dis205.lab2_6.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

//@Getter@Setter
@Entity
public class Trip {
    private Long id;
    //@Temporal(TemporalType.TIMESTAMP) для типа данных Date
    private LocalDateTime startTime;
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime finishTime;
    //@ManyToOne(cascade = CascadeType.ALL)
    private Car car;
    //@ManyToOne(cascade = CascadeType.ALL)
    private Passenger passenger;
    private String startPoint;
    private String finishPoint;
    //@ManyToOne(cascade = CascadeType.ALL)
    private Driver driver;

    @Id
    @SequenceGenerator(name = "trip_gen", sequenceName = "trip_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "trip_gen")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getStartPoint() {
        System.out.println("getStartPoint " + startPoint);
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getFinishPoint() {
        return finishPoint;
    }

    public void setFinishPoint(String finishPoint) {
        this.finishPoint = finishPoint;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
