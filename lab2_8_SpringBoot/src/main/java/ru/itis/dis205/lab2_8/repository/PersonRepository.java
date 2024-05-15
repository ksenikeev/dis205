package ru.itis.dis205.lab2_8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryRewriter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.dis205.lab2_8.dto.PersonDto;
import ru.itis.dis205.lab2_8.model.Person;
import ru.itis.dis205.lab2_8.model.PersonView;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select p from Person p where p.name like :name and p.passport.paspnum like :paspnum ")
    Iterable<Person> findPerson(@Param("name") String name,
                                @Param("paspnum") String paspnum);

    Iterable<Person> findPersonByName(String name);

    @Query("select new ru.itis.dis205.lab2_8.dto.PersonDto(p.id, p.name, p.passport.paspnum) from Person p")
    List<PersonDto> findAllToPersonDto();


    @Modifying
    @Query("update Person p set name = :name where id = :id")
    void updatePerson(@Param("name") String name, @Param("id") Long id);

    @Modifying
    @Query("Delete from Person p  where id = :id")
    void deletePerson( @Param("id") Long id);
}
