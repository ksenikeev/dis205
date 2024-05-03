package ru.itis.dis205.lab2_12.web.model.transport;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter@Getter
@Entity
public class Transport {
    @Id
    private String id;
    private String threadId;
    private String lineId;
    private String name;
    //@Transient
    @JsonProperty("Types")
    private List<String> sypes;
    private String type;
    private String uri;
    private String seoname;
}