package ru.itis.dis205.lab2_12.web.model.transport;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter@Getter
public class Data {
    private List<Vehicle> vehicles;
    private RegionInfo regionInfo;
}
