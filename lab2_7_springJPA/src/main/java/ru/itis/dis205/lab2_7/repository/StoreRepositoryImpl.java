package ru.itis.dis205.lab2_7.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dis205.lab2_7.model.Store;
import java.util.List;

@Repository
public class StoreRepositoryImpl implements StoreRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    //@Transactional
    public Store save(Store store) {
        return entityManager.merge(store);
    }

    @Override
    public List<Store> findAll() {
        Query query = entityManager.createQuery("select s from Store s");
        return query.getResultList();
    }

    @Override
    public List<Store> findByName(String name) {
        Query query = entityManager.createQuery("select s from Store s where name like :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public Store findById(Long id) {
        return entityManager.find(Store.class, id);
    }
}
