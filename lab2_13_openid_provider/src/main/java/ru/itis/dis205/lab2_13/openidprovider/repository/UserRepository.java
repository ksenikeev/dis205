package ru.itis.dis205.lab2_13.openidprovider.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itis.dis205.lab2_13.openidprovider.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
