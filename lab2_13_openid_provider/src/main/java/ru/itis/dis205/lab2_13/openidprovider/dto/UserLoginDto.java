package ru.itis.dis205.lab2_13.openidprovider.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class UserLoginDto {
    private String username;
    private String password;
    private Long developerid;
}
