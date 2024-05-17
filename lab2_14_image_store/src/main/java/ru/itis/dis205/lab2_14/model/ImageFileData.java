package ru.itis.dis205.lab2_14.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter@Setter
@Entity
public class ImageFileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Будем оперировать с двумя путями
    // 1. Путь к хранилищу
    // 2. Путь к файлу, относительно хранилища
    // (1) /home/ksenikeev/imagestore (2) /avatar/2/avatar.jpg
    private String path; // (2) /avatar/2/

    private String fileName; // avatar.jpg

    private String fileType;

    @ManyToOne
    private User user;
    private LocalDateTime attachDate;
}
