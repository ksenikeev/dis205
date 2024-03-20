package ru.itis.dis205.lab2_6;

import ru.itis.dis205.lab2_6.model.Car;
import ru.itis.dis205.lab2_6.model.CarColor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        //1. create EntityManagerFactory
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("lab2_6");

        Car car = new Car();
        car.setId(2l);
        car.setCarNumber("A001AA");
        car.setCarBrand("Лада");
        car.setColor(CarColor.black);

        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(car);

        transaction.commit();
        entityManager.close();

    }
}
