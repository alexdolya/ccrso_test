package ru.dolya.mcrs_test.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long id;

    @Column(name = "city")
    private String cityName;

    @OneToMany(mappedBy = "city")
    private List<Weather> weatherList;
}
