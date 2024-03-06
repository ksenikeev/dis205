package ru.itis.dis205.lab2_5.model;

import lombok.Getter;
import lombok.Setter;
import ru.itis.dis205.lab2_5.annotation.Entity;
import ru.itis.dis205.lab2_5.annotation.ManyToOne;

@Getter@Setter
@Entity
public class MusicTrack {
    private Integer id;
    private String name;
    private Integer length;
    @ManyToOne
    private Musician musician;
    @ManyToOne
    private Autor autor;
    private String date;
    @ManyToOne
    private Genre genre;
}
