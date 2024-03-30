package ru.itis.dis205.lab2_7.repository;

import org.springframework.stereotype.Repository;
import ru.itis.dis205.lab2_7.model.Store;

import java.util.List;


public interface StoreRepository {

    Store save(Store store);
    List<Store> findAll();
    List<Store> findByName(String name);
    Store findById(Long id);
}
