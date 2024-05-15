package ru.itis.dis205.lab2_13.openidprovider.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itis.dis205.lab2_13.openidprovider.model.Developer;

public interface DeveloperRepository extends CrudRepository<Developer, Long> {
    Developer findByCallbackurl(String callbackurl);
}
