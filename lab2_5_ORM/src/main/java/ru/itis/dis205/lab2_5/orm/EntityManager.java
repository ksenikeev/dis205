package ru.itis.dis205.lab2_5.orm;

import java.util.List;

public interface EntityManager {

    <T> T save(T entity);
    void remove(Object entity);
    /* Ищем объект типа T по значению первичного ключа key */
    <T> T find(Class<T> entityType, Object key);
    <T> List<T> findAll(Class<T> entityType);
}
