package ru.dolya.mcrs_test.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "temp")
    private double temp;

    @Column(name = "description")
    private String description;

    @Column(name = "wind_speed")
    private double windSpeed;

    @Column(name = "wind_deg")
    private int windDeg;

    @Column(name = "clouds")
    private int clouds;

    @Column(name = "pressure")
    private int pressure;

    @Column(name = "humidity")
    private int humidity;

    @Column(name = "date_time")
    private LocalDateTime dateTime;
}
