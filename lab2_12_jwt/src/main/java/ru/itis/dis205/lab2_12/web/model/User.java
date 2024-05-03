package ru.itis.dis205.lab2_12.web.model;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

import static jakarta.persistence.InheritanceType.JOINED;

@Getter@Setter
@Builder
@Entity
@Table(name = "users")
@Inheritance(strategy = JOINED)
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Enumerated(value = EnumType.STRING)
    private RoleType userRole;
    private String hashPassword;
}
