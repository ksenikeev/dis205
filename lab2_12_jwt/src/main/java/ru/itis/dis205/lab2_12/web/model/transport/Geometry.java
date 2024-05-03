package ru.itis.dis205.lab2_12.web.model.transport;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class Geometry {
    String type;
    List<Double[]> coordinates;
}
