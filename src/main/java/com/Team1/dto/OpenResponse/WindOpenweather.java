package com.Team1.dto.OpenResponse;

public class WindOpenweather {

    private double deg;
    private double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "WindOpenweather{" +
                "deg=" + deg +
                ", speed=" + speed +
                '}';
    }
}
