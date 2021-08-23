package com.Team1.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "averaged_weather_data")
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AveragedWeatherData extends BaseEntity{

    private LocalDate date;

    private double temperature;

    @Column(name = "atmospheric_pressure")
    private double atmosphericPresure;

    private double humidity;

    @Column(name = "wind_direction")
    private String windDirection;

    @Column (name = "wind_speed")
    private double windSpeed;

    @Column (name = "localisation_id")
    private Long  localisationID;
}
