package ru.dolya.mcrs_test.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.dolya.mcrs_test.model.entity.City;

public interface CityRepository extends CrudRepository<City, Long> {
}
