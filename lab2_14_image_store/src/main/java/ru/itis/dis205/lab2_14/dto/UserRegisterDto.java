package ru.itis.dis205.lab2_14.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDto {
    private String username;
    private String password;
    private String email;
}
