package ru.itis.dis205.lab2_13.openidprovider.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "developer")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String appname;
    private String homepage;
    private String appdecript;
    @Column(unique=true)
    private String callbackurl;
    private String token;
}
