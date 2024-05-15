package ru.itis.dis205.lab2_13.openidprovider.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.itis.dis205.lab2_13.openidprovider.model.User;

@Getter@Setter@Builder@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String description;

    public UserDto() {}

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.description = user.getDescription();
    }
}
