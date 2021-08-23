package com.Team1.dto;

public class AccuweatherResponseByKeyTemperatureMetric {
    private double Value;

    public double getValue() {
        return Value;
    }

    public void setValue(double Value) {
        this.Value = Value;
    }

    @Override
    public String toString() {
        return "AccuweatherResponseByKeyTemperatureMetric{" +
                "Value=" + Value +
                '}';
    }
}
