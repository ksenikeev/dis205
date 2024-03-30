package ru.itis.dis205.lab2_7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dis205.lab2_7.model.Merch;
import ru.itis.dis205.lab2_7.model.Store;
import ru.itis.dis205.lab2_7.repository.MerchRepository;
import ru.itis.dis205.lab2_7.repository.StoreRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class StoreService {

    @Autowired
    private MerchRepository repository;

    @Autowired
    private StoreRepository storeRepository;

    @Transactional
    public Store addStore() {
        Store store = new Store();
        store.setName("Склад 1");
        store.setAddress("Роторная 123б");

        Collection<Merch> merches = new ArrayList<>();

        Merch merch = new Merch();
        merch.setName("Пылесос");
        merch.setPrice(5000D);

        merch = repository.save(merch);

        merches.add(merch);

        Merch merch1 = repository.findById(1l);

        merches.add(merch1);

        store.setMerches(merches);

        storeRepository.save(store);

        return store;
    }

    public Store findById(Long id) {
        return storeRepository.findById(id);
    }
}
