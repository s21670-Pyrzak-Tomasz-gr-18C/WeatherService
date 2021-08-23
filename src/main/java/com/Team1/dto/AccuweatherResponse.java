package com.Team1.dto;

public class AccuweatherResponse {
    private Integer key;

    public void setKey(Integer key){this.key=key;}

    public Integer getKey(){return key;}

    @Override
    public String toString() {
        return "AccuweatherResponse{" +
                "cityKey='" + key + '\'' +
                '}';
    }
}
