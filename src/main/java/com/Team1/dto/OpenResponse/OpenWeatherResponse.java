package com.Team1.dto.OpenResponse;

import com.fasterxml.jackson.annotation.JsonGetter;

public class OpenWeatherResponse {

    private MainOpenweather main;
    private WindOpenweather wind;

    @JsonGetter

    public MainOpenweather getMain() {
        return main;
    }

    public void setMain(MainOpenweather main) {
        this.main = main;
    }

    public WindOpenweather getWind() {
        return wind;
    }

    public void setWind(WindOpenweather wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "OpenWeatherResponse{" +
                "main=" + main +
                ", wind=" + wind +
                '}';
    }
}
