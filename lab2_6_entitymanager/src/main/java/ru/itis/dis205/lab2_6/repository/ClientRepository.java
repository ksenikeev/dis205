package ru.itis.dis205.lab2_6.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.itis.dis205.lab2_6.model.Client;
import ru.itis.dis205.lab2_6.model.Driver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class ClientRepository {

    @Autowired
    private EntityManagerFactory emf;

    private EntityManager entityManager;

    public Client save(Client trip) {
        entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        if (trip.getId() != null) {
            entityManager.merge(trip);
        } else {
            entityManager.persist(trip);
        }
        entityManager.getTransaction().commit();
        entityManager.close();


        return trip;
    }

}
