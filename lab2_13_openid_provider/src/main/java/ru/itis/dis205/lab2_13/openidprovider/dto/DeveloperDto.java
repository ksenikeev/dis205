package ru.itis.dis205.lab2_13.openidprovider.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeveloperDto {
    private String appname;
    private String homepage;
    private String appdecript;
    private String callbackurl;
}
