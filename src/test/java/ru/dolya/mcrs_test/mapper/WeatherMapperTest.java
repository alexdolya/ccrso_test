package ru.dolya.mcrs_test.mapper;

import org.junit.jupiter.api.Test;
import ru.dolya.mcrs_test.model.dto.*;
import ru.dolya.mcrs_test.model.entity.City;
import ru.dolya.mcrs_test.model.entity.Weather;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class WeatherMapperTest {


    @Test
    void getWeather() {
        WeatherMapper weatherMapper = new WeatherMapper();

        WeatherDTO weatherDTO = new WeatherDTO()
                .setCoord(new CoordDTO())
                .setWeather(new WeatherInfoDTO[]{new WeatherInfoDTO().setDescription("rain")})
                .setBase("base")
                .setMain(new MainDTO().setTemp(27.0).setPressure(755).setHumidity(99))
                .setVisibility(1000)
                .setWind(new WindDTO().setSpeed(123).setDeg(90))
                .setClouds(new CloudsDTO().setAll(50))
                .setDt(System.currentTimeMillis())
                .setSys(new SysDTO())
                .setTimezone(0)
                .setDt(1695438000L)
                .setId(1)
                .setCod(200);

        City city = new City().setCityName("Moscow");

        Weather weather = weatherMapper.getWeather(weatherDTO, city);

        assertEquals("Moscow", weather.getCity().getCityName());
        assertEquals(27.0, weather.getTemp());
        assertEquals("rain", weather.getDescription());
        assertEquals(123, weather.getWindSpeed());
        assertEquals(90, weather.getWindDeg());
        assertEquals(50, weather.getClouds());
        assertEquals(755, weather.getPressure());
        assertEquals(99, weather.getHumidity());
        assertEquals(LocalDateTime.of(LocalDate.of(2023, 9, 23),
                LocalTime.of(7, 0, 0)), weather.getDateTime());
    }


}