package ru.itis.dis205.lab2_5.orm;

public interface EntityManager {

    <T> T save(T entity);
    void remove(Object entity);
    /* Ищем объект типа T по значению первичного ключа key */
    <T> T find(Class<T> entityType, Object key);
}
