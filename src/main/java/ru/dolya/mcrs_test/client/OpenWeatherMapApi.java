package ru.dolya.mcrs_test.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.dolya.mcrs_test.model.dto.WeatherDTO;


@FeignClient(name = "OpenWeatherMapApi", url = "https://api.openweathermap.org/data/2.5")
public interface OpenWeatherMapApi {
    @GetMapping("/weather")
    WeatherDTO getWeatherInCity(@RequestParam("q") String cityName, @RequestParam("appid") String appId, @RequestParam("units") String units);
}
