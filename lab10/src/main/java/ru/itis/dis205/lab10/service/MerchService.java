package ru.itis.dis205.lab10.service;

import ru.itis.dis205.lab10.model.Client;
import ru.itis.dis205.lab10.model.Merch;
import ru.itis.dis205.lab10.repository.ClientRepository;
import ru.itis.dis205.lab10.repository.MerchRepository;

import java.util.List;

public class MerchService {

    private MerchRepository repository;

    public MerchService() {
        repository = new MerchRepository();
    }

    public List<Merch> findAll() {
        return repository.findAll();
    }
}
