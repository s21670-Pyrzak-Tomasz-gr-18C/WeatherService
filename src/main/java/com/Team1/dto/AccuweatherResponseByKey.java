package com.Team1.dto;

import com.fasterxml.jackson.annotation.JsonGetter;

public class AccuweatherResponseByKey {

    private AccuweatherResponseByKeyTemperature Temperature;

    @JsonGetter("temperature")
    public AccuweatherResponseByKeyTemperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(AccuweatherResponseByKeyTemperature Temperature) {
        this.Temperature = Temperature;
    }

    @Override
    public String toString() {
        return "AccuweatherResponseByKey{" +
                "Temperature=" + Temperature +
                '}';
    }
}
