package com.Team1.dto.AccuResponse.wind.windspeed;

import com.fasterxml.jackson.annotation.JsonGetter;

public class WindSpeedMetricAccuweather {
    private double Value;


    public void setValue(double value) {
        this.Value = value;
    }

    @JsonGetter("Value")
    public double getValue() {
        return Value;
    }

    @Override
    public String toString() {
        return "WindSpeedMetricAccuweather{" +
                "Value=" + Value +
                '}';
    }
}
