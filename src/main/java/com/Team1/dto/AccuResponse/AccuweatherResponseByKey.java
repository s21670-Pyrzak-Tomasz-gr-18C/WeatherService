package com.Team1.dto.AccuResponse;

import com.Team1.dto.AccuResponse.pressure.PressureAccuweather;
import com.Team1.dto.AccuResponse.temperature.TemperatureAccuweather;
import com.Team1.dto.AccuResponse.wind.WindAccuweather;
import com.Team1.dto.AccuResponse.wind.winddirection.WindDirectionAccuweather;
import com.fasterxml.jackson.annotation.JsonGetter;

public class AccuweatherResponseByKey {

     TemperatureAccuweather Temperature;
     Integer RelativeHumidity;
     WindAccuweather Wind;
     PressureAccuweather Pressure;


    public void setPressure(PressureAccuweather pressure) {
        Pressure = pressure;
    }

    public void setRelativeHumidity(Integer relativeHumidity) {
        RelativeHumidity = relativeHumidity;
    }

    public void setTemperature(TemperatureAccuweather temperature) {
        Temperature = temperature;

    }

    public void setWind(WindAccuweather wind) {
        Wind = wind;
    }

    @JsonGetter("Pressure")
    public PressureAccuweather getPressure() {
        return Pressure;
    }

    @JsonGetter("Temperature")
    public TemperatureAccuweather getTemperature() {
        return Temperature;
    }

    @JsonGetter("RelativeHumidity")
    public Integer getRelativeHumidity() {
        return RelativeHumidity;
    }

    @JsonGetter("Wind")
    public WindAccuweather getWind() {
        return Wind;
    }

    @Override
    public String toString() {
        return "AccuweatherResponseByKey{" +
                "Temperature=" + Temperature +
                ", RelativeHumidity=" + RelativeHumidity +
                ", Wind=" + Wind +
                ", Pressure=" + Pressure +
                '}';
    }
}
