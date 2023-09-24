package ru.dolya.mcrs_test.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.dolya.mcrs_test.client.OpenWeatherMapApi;
import ru.dolya.mcrs_test.mapper.WeatherMapper;
import ru.dolya.mcrs_test.model.dto.WeatherDTO;
import ru.dolya.mcrs_test.model.entity.City;
import ru.dolya.mcrs_test.model.entity.Weather;
import ru.dolya.mcrs_test.repository.CityRepository;
import ru.dolya.mcrs_test.repository.WeatherRepository;
import ru.dolya.mcrs_test.service.WeatherService;

import java.util.List;

@Log4j2
@EnableScheduling
@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final OpenWeatherMapApi openWeatherMapApi;
    private final CityRepository cityRepository;
    private final WeatherRepository weatherRepository;
    private final CityReaderImpl cityReader;
    private final WeatherMapper weatherMapper;


    @Value("${openweathermap.appid}")
    private String appId;

    @Scheduled(fixedRate = 3600_000)
    public void getWeather() {

        if (cityRepository.count() == 0) {
            List<String> cityNamesList = cityReader.getCities();
            for (String cityName : cityNamesList) {
                cityRepository.save(new City().setCityName(cityName));
                log.info("City saved to DB: {}", cityName);
            }
        }

        Iterable<City> cities = cityRepository.findAll();

        for (City city : cities) {
            String UNIT = "metric";
            WeatherDTO weatherDTO = openWeatherMapApi.getWeatherInCity(city.getCityName(), appId, UNIT);
            Weather weather = weatherMapper.getWeather(weatherDTO, city);
            weatherRepository.save(weather);
            log.info("Weather have been saved to DB. City: {}, Temp: {}, Description: {}",
                    city.getCityName(), weather.getTemp(), weather.getDescription());
        }
    }

}
