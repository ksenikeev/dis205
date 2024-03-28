package ru.itis.dis205.lab2_7.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EntityRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public T save(T t) {
        return entityManager.merge(t);
    }
}
