package ru.dolya.mcrs_test.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.dolya.mcrs_test.service.CityReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityReaderImpl implements CityReader {
    @Value("${citieslist.path}")
    private String citiesListPath;
    public List<String> getCities() {
        List<String> cities = new ArrayList<>();
        try {
            Path filePath = Path.of(citiesListPath);
            cities = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }

}