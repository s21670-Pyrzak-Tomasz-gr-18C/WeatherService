package com.Team1.dto;

public class WindOpenweather {

    private double deg;

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
                '}';
    }
}
