package com.Team1.dto;

public class AccuweatherResponse {
    private String Key;

    public void setKey(String cityKey){this.Key=Key;}

    public String getKey(){return Key;}

    @Override
    public String toString() {
        return "AccuweatherResponse{" +
                "cityKey='" + Key + '\'' +
                '}';
    }
}
