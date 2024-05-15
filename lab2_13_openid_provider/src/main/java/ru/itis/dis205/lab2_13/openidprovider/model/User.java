package ru.itis.dis205.lab2_13.openidprovider.model;

import jakarta.persistence.*;
import lombok.*;

@Getter@Setter@Builder@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String description;

    public User() {}
}
