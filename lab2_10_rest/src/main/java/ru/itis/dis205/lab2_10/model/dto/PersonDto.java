package ru.itis.dis205.lab2_10.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

@Getter@Setter@ToString
public class PersonDto {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private String passport;
}
