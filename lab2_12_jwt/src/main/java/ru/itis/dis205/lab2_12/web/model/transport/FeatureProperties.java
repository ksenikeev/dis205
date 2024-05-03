package ru.itis.dis205.lab2_12.web.model.transport;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class FeatureProperties {
    private String type;
    @JsonProperty("TrajectorySegmentMetaData")
    private TrajectorySegmentMetaData trajectorySegmentMetaData;
}