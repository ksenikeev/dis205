package ru.itis.dis205.lab2_14.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dis205.lab2_14.model.User;
import ru.itis.dis205.lab2_14.service.UserService;

@Service
public class UserDetailsServiseImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);
        if (user != null) {
            return new UserDetailImpl(user);
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }
}
