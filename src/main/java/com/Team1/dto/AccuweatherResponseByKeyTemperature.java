package com.Team1.dto;

import com.fasterxml.jackson.annotation.JsonGetter;

public class AccuweatherResponseByKeyTemperature {

    private AccuweatherResponseByKeyTemperatureMetric Metric;

    @JsonGetter("metric")
    public AccuweatherResponseByKeyTemperatureMetric getMetric() {
        return Metric;
    }

    public void setMetric(AccuweatherResponseByKeyTemperatureMetric Metric) {
        this.Metric = Metric;
    }

    @Override
    public String toString() {
        return "AccuweatherResponseByKeyTemperature{" +
                "Metric=" + Metric +
                '}';
    }
}
