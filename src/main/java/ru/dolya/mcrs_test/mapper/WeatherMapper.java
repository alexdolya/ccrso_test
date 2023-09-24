package ru.dolya.mcrs_test.mapper;

import org.springframework.stereotype.Component;
import ru.dolya.mcrs_test.model.dto.WeatherDTO;
import ru.dolya.mcrs_test.model.dto.WeatherInfoDTO;
import ru.dolya.mcrs_test.model.entity.City;
import ru.dolya.mcrs_test.model.entity.Weather;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class WeatherMapper {

    public Weather getWeather(WeatherDTO weatherDTO, City city) {

        return new Weather().setCity(city)
                .setTemp(weatherDTO.getMain().getTemp())
                .setDescription(getWeatherDescription(weatherDTO))
                .setWindSpeed(weatherDTO.getWind().getSpeed())
                .setWindDeg(weatherDTO.getWind().getDeg())
                .setClouds(weatherDTO.getClouds().getAll())
                .setPressure(weatherDTO.getMain().getPressure())
                .setHumidity(weatherDTO.getMain().getHumidity())
                .setDateTime(getLocaleDateTimeFromMillis(weatherDTO));
    }


    private LocalDateTime getLocaleDateTimeFromMillis(WeatherDTO weatherDTO){
        return Instant.ofEpochMilli(weatherDTO.getDt()*1000)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }


    private String getWeatherDescription(WeatherDTO weatherDTO) {
        StringBuilder description = new StringBuilder();
        for (WeatherInfoDTO weatherInfoDTO : weatherDTO.getWeather()) {
            description.append(weatherInfoDTO.getDescription());
            description.append(" ");
        }
        return description.toString().trim();
    }

}
