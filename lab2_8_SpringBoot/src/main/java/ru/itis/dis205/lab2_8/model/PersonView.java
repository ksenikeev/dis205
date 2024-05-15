package ru.itis.dis205.lab2_8.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * create view personview as
 * select p.id, name, coalesce(paspnum,'') as paspnum
 * from person p left join passport psp on psp.id=passport_id;
 */

@Getter@Setter@ToString
@Entity
public class PersonView {
    @Id
    private Long id;
    private String name;
    private String paspnum;
}
