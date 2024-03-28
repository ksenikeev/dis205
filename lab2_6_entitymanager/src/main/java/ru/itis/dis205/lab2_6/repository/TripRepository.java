package ru.itis.dis205.lab2_6.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.itis.dis205.lab2_6.model.Trip;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class TripRepository {

    @Autowired
    private EntityManagerFactory emf;

    private EntityManager entityManager;

    public Trip save(Trip trip) {
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(trip);

        trip.setFinishPoint("Ульяновск");

        entityManager.getTransaction().commit();
        entityManager.close();
        return trip;
    }
}
