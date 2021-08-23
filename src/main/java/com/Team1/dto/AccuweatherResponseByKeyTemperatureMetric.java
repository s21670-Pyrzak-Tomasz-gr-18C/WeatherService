package com.Team1.dto;

public class AccuweatherResponseByKeyTemperatureMetric {
    private double Value;

    public double getValue() {
        return Value;
    }

    public void setValue(double value) {
        Value = value;
    }

    @Override
    public String toString() {
        return "AccuweatherResponseByKeyTemperatureMetric{" +
                "Value=" + Value +
                '}';
    }
}
