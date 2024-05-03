package ru.itis.dis205.lab2_12.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dis205.lab2_12.web.dto.UserDto;
import ru.itis.dis205.lab2_12.web.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import ru.itis.dis205.lab2_12.web.security.detail.UserDetailsImpl;

import java.util.List;

@RestController
public class AdminUsersConroller {

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin/users")
    public ResponseEntity<List<UserDto>> findAllUser() {
       return ResponseEntity.ok(userRepository.findAll().stream().map(UserDto::from).toList());
    }

    @GetMapping("/admin/userinfo")
    public ResponseEntity<UserDto> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl details = (UserDetailsImpl) authentication.getDetails();
        return ResponseEntity.ok(UserDto.from(details.getUser()));
    }

}
