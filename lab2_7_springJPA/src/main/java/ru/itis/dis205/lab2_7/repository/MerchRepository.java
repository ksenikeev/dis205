package ru.itis.dis205.lab2_7.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dis205.lab2_7.model.Merch;

import java.util.List;

@Repository
public class MerchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Merch save(Merch t) {
        return entityManager.merge(t);
    }

    public List<Merch> findAllNative() {
        // Чистый SQL
        Query query = entityManager.createNativeQuery("select * from merch", Merch.class);
        return query.getResultList();
    }

    public List<Merch> findAll() {
        //
        Query query = entityManager.createQuery("select m from Merch m ");
        return query.getResultList();
    }


    public List<Merch> findAllByName(String name) {
        //
        Query query = entityManager.createQuery("select m from Merch m where m.name like :name ");
        query.setParameter("name", name + "%");

        return query.getResultList();
    }
}
