package ru.dolya.mcrs_test.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MainDTO {
    private double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private int pressure;
    private int humidity;
}
