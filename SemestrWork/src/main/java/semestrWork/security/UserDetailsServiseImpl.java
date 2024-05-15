package semestrWork.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import semestrWork.model.User;

import semestrWork.repository.UserRepository;
import semestrWork.service.UserService;


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
