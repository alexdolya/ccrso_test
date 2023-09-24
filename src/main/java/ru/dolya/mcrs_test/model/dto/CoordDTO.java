package ru.dolya.mcrs_test.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CoordDTO {
    private double lon;
    private double lat;
}
