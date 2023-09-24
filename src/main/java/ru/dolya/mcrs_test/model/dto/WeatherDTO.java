package ru.dolya.mcrs_test.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WeatherDTO {
    private CoordDTO coord;
    private WeatherInfoDTO[] weather;
    private String base;
    private MainDTO main;
    private int visibility;
    private WindDTO wind;
    private CloudsDTO clouds;
    private long dt;
    private SysDTO sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;
}