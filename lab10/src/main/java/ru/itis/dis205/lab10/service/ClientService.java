package ru.itis.dis205.lab10.service;

import ru.itis.dis205.lab10.model.Client;
import ru.itis.dis205.lab10.repository.ClientRepository;

import java.util.List;

public class ClientService {

    private ClientRepository repository;

    public ClientService() {
        repository = new ClientRepository();
    }

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(Long id) {
        return repository.findById(id);
    }

    public Client findByUserName(String userName) {
        return repository.findByUserName(userName);
    }
}
