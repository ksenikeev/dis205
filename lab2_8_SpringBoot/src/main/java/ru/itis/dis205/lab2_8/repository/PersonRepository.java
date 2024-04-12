package ru.itis.dis205.lab2_8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.dis205.lab2_8.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select p from Person p where p.name like :name and p.passport.paspnum like :paspnum ")
    Iterable<Person> findPerson(@Param("name") String name,
                                @Param("paspnum") String paspnum);

    Iterable<Person> findPersonByName(String name);

}
