package ru.itis.dis205.lab2_14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dis205.lab2_14.model.User;
import ru.itis.dis205.lab2_14.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Boolean existsUserByUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }

    @Transactional
    public User save(User user) {
         return userRepository.save(user);
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
