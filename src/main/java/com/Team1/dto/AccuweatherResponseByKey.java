package com.Team1.dto;

public class AccuweatherResponseByKey {
    private AccuweatherResponseByKeyTemperature Temperature;

    public AccuweatherResponseByKeyTemperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(AccuweatherResponseByKeyTemperature temperature) {
        Temperature = temperature;
    }

    @Override
    public String toString() {
        return "AccuweatherResponseByKey{" +
                "Temperature=" + Temperature +
                '}';
    }
}
