package com.Team1.dto.AccuResponse.wind;

import com.Team1.dto.AccuResponse.wind.winddirection.WindDirectionAccuweather;
import com.Team1.dto.AccuResponse.wind.windspeed.WindSpeedAccuweather;
import com.fasterxml.jackson.annotation.JsonGetter;

public class WindAccuweather {
    private WindSpeedAccuweather Speed;
    private WindDirectionAccuweather Direction;

    public void setSpeed(WindSpeedAccuweather speed) {
        Speed = speed;
    }

    public void setDirection(WindDirectionAccuweather direction) {
        Direction = direction;
    }

    @JsonGetter("Speed")
    public WindSpeedAccuweather getSpeed() {
        return Speed;
    }

    @JsonGetter("Direction")
    public WindDirectionAccuweather getDirection() {
        return Direction;
    }

    @Override
    public String toString() {
        return "WindAccuweather{" +
                "Speed=" + Speed +
                ", Direction=" + Direction +
                '}';
    }
}
