package ru.itis.dis205.lab2_10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dis205.lab2_10.model.Person;
import ru.itis.dis205.lab2_10.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Transactional
    public Person save(Person person) {
        return repository.save(person);
    }

    public Iterable<Person> findAll() {
        return repository.findAll();
    }

    public Iterable<Person> findPerson(String name, String paspnum) {
        //return repository.findPerson(name + "%", paspnum + "%");
        return repository.findPersonByName(name + "%");
    }
}
