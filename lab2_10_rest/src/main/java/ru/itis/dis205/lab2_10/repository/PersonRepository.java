package ru.itis.dis205.lab2_10.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.itis.dis205.lab2_10.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select p from Person p where p.name like :name and p.passport.paspnum like :paspnum ")
    Iterable<Person> findPerson(@Param("name") String name,
                                @Param("paspnum") String paspnum);

    Iterable<Person> findPersonByName(String name);

}
