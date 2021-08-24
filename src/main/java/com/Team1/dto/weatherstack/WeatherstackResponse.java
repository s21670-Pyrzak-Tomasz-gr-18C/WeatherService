package com.Team1.dto.weatherstack;
import com.Team1.dto.weatherstack.CurrentWeatherstack;
import com.fasterxml.jackson.annotation.JsonGetter;
public class WeatherstackResponse {

    private CurrentWeatherstack current;

    @JsonGetter

    public CurrentWeatherstack getCurrent() {
        return current;
    }

    public void setCurrent(CurrentWeatherstack current) {
        this.current = current;
    }


    @Override
    public String toString() {
        return "WeatherstackResponse{" +
                "current=" + current +
                '}';
    }
}
