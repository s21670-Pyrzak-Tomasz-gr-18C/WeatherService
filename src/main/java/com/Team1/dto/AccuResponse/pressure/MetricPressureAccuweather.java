package com.Team1.dto.AccuResponse.pressure;

import com.fasterxml.jackson.annotation.JsonGetter;

public class MetricPressureAccuweather {
    private double Value;

    @JsonGetter("Value")
    public double getValue() {
        return Value;
    }

    public void setValue(double value) {
        Value = value;
    }

    @Override
    public String toString() {
        return "MetricPressureAccuweather{" +
                "Value=" + Value +
                '}';
    }
}
