package ru.dolya.mcrs_test.repository;

import org.springframework.data.repository.CrudRepository;
import ru.dolya.mcrs_test.model.entity.Weather;

public interface WeatherRepository extends CrudRepository<Weather, Long> {
}
