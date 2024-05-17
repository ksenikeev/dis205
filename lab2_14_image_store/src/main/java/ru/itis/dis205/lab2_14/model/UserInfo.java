package ru.itis.dis205.lab2_14.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Getter@Setter
@Entity
public class UserInfo {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name = "property", value = "users"))
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    private ImageFileData avatar;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_images", // user_info_image_collection
            joinColumns = @JoinColumn(name="user_id"), // user_info_id
            inverseJoinColumns = @JoinColumn(name = "image_id")) // image_collection_id
    private List<ImageFileData> imageCollection;
}
