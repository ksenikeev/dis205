package semestrWork.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}
