package ru.dolya.mcrs_test.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WindDTO {
    private double speed;
    private int deg;
    private double gust;
}