package ru.itis.dis205.lab10.service;

import ru.itis.dis205.lab10.model.Bank;
import ru.itis.dis205.lab10.repository.BankRepository;

import java.util.List;

public class BankService {

    private BankRepository repository;

    public BankService() {
        repository = new BankRepository();
    }

    public List<Bank> findAll() {
        return repository.findAll();
    }

}
