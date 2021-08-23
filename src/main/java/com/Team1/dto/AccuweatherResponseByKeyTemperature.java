package com.Team1.dto;

public class AccuweatherResponseByKeyTemperature {
    private AccuweatherResponseByKeyTemperature Metric;

    public AccuweatherResponseByKeyTemperature getMetric() {
        return Metric;
    }

    public void setMetric(AccuweatherResponseByKeyTemperature metric) {
        Metric = metric;
    }

    @Override
    public String toString() {
        return "AccuweatherResponseByKeyTemperature{" +
                "Metric=" + Metric +
                '}';
    }
}
