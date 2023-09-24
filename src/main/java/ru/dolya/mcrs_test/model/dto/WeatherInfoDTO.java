package ru.dolya.mcrs_test.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WeatherInfoDTO {
    private int id;
    private String main;
    private String description;
    private String icon;
}