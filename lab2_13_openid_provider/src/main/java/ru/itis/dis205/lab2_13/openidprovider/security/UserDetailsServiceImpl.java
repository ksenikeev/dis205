package ru.itis.dis205.lab2_13.openidprovider.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itis.dis205.lab2_13.openidprovider.model.User;
import ru.itis.dis205.lab2_13.openidprovider.service.UserService;

@Service(value = "myUserDetailsServise")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("loadUserByUsername");

        User user = userService.findByUsername(username);
        if (user != null) {
            UserDetailsImpl userDetails = new UserDetailsImpl();
            userDetails.setUser(user);
        } else {
            throw new AuthenticationServiceException("");
        }
        return null;
    }
}
