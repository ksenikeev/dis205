package ru.itis.dis205.lab2_12.web.model.transport;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class Feature {
    private Geometry geometry;
    private FeatureProperties properties;
}
