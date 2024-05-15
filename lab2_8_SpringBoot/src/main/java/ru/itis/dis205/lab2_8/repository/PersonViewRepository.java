package ru.itis.dis205.lab2_8.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dis205.lab2_8.model.PersonView;

import java.util.List;

public interface PersonViewRepository extends CrudRepository<PersonView, Long> {
    @Transactional
    PersonView save(PersonView pw);

    @Query(value = "select id,name,paspnum from personviewasfunc(:id)", nativeQuery = true)
    List<PersonView> findAllToPersonFunc(@Param("id") Long id);
}
