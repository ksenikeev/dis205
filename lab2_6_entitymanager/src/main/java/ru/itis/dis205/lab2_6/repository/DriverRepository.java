package ru.itis.dis205.lab2_6.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.itis.dis205.lab2_6.model.Driver;
import ru.itis.dis205.lab2_6.model.Trip;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class DriverRepository {

    @Autowired
    private EntityManagerFactory emf;

    private EntityManager entityManager;

    public Driver save(Driver trip) {
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(trip);
        entityManager.getTransaction().commit();
        entityManager.close();
        return trip;
    }
}
