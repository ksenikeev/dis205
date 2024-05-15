package semestrWork.repository;

import org.springframework.data.repository.CrudRepository;
import semestrWork.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUsername(String username);

    Boolean existsUserByUsername(String username);
}
