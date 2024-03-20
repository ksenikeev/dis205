package ru.itis.dis205.lab2_6;

import ru.itis.dis205.lab2_6.model.Car;
import ru.itis.dis205.lab2_6.model.CarColor;
import ru.itis.dis205.lab2_6.model.Passenger;
import ru.itis.dis205.lab2_6.model.Trip;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class Main2 {
    public static void main(String[] args) {

        //1. create EntityManagerFactory
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("lab2_6");

        Car car = new Car();
        car.setId(4l);
        car.setCarNumber("A004AA");
        car.setCarBrand("Лада");
        car.setColor(CarColor.white);

        Passenger passenger = new Passenger();
        passenger.setId(2l);
        passenger.setName("Passanger 2");
        passenger.setPhone("+799999999");

        Trip trip = new Trip();
        trip.setId(2l);
        trip.setPassenger(passenger);
        trip.setCar(car);
        trip.setStartPoint("Кремлевская 18");
        trip.setFinishPoint("Кремлевская 35");
        trip.setStartTime(LocalDateTime.now());

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //entityManager.persist(car);
        //entityManager.persist(passenger);
        entityManager.persist(trip);

        transaction.commit();
        entityManager.close();

    }
}
