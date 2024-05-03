package ru.itis.dis205.lab2_12.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.itis.dis205.lab2_12.web.model.User;

@Getter@Setter@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;

    public static UserDto from(User user) {
        return new UserDto(user.getId(), user.getName());
    }
}
