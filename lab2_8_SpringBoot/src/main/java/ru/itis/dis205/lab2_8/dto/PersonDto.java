package ru.itis.dis205.lab2_8.dto;

import lombok.*;

/**
 * create view personview as
 * select p.id, name, coalesce(paspnum,'') as paspnum
 * from person p left join passport psp on psp.id=passport_id;
 */

@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
public class PersonDto {
    private Long id;
    private String name;
    private String paspnum;
}
