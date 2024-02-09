package ru.itis.dis205.lab2_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Component
public class PersonRepository {

    private List<Person> persons;

    public PersonRepository() {
        persons = new ArrayList<>();

        for (int i = 1; i < 11; ++i) {
            Person person = new Person();
            person.setId(i);
            person.setFio("person_" + i);
            persons.add(person);
        }
    }

    public Optional<Person> findById(Integer id) {
        return persons.stream().filter(person -> {
            return person.getId()==id;
        }).findFirst();
    }

    public void add(Person person) throws EmtyPersonException {
        if (person == null) {
            throw new EmtyPersonException();
        }
        Optional<Person> op = findById(person.getId());
        if (op.isPresent()) {
            op.get().setFio(person.getFio());
        } else {
            persons.add(person);
        }
    }

}
