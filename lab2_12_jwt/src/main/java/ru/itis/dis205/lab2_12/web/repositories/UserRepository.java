package ru.itis.dis205.lab2_12.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.dis205.lab2_12.web.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
