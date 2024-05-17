package ru.itis.dis205.lab2_14.repository;

import org.springframework.data.repository.CrudRepository;
import ru.itis.dis205.lab2_14.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUsername(String username);

    Boolean existsUserByUsername(String username);
}
