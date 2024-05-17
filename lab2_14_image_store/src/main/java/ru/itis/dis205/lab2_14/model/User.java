package ru.itis.dis205.lab2_14.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

import static jakarta.persistence.InheritanceType.JOINED;

@Getter@Setter
@Entity
@Table(name = "users")
@Inheritance(strategy = JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private List<UserRole> roles;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserInfo userInfo;

    public void setDefaultRole() {
        if (roles == null || roles.isEmpty()) {
            roles = Arrays.asList(UserRole.USER);
        }
    }
}
