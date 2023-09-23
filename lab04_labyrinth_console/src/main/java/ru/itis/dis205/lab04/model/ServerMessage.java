package ru.itis.dis205.lab04.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ServerMessage {
    private String status;
    private String message;
    private List<Integer> startPoint;
    private String direction;
}
