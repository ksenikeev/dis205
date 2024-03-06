package ru.itis.dis205.lab2_5.orm;

import java.util.Map;

public class EntityManagerImpl implements EntityManager {

    private Map<String, Object> entityes;


    /*
        1. Создаем подключение к БД (JDBC Connection)
        2. Сканируем структуру классов
        3. Запрашиваем структуру БД
        4. Проверяем соответствие объектная модели - реляционная модель:
        нашли класс - наличие таблицы
        нашли поле - наличие поля в таблице
     */



    @Override
    public <T> T save(T entity) {
        return null;
    }

    @Override
    public void remove(Object entity) {

    }

    @Override
    public <T> T find(Class<T> entityType, Object key) {
        return null;
    }
}
