package ru.dolya.mcrs_test.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public  class SysDTO {
    private int type;
    private int id;
    private String country;
    private long sunrise;
    private long sunset;
}
