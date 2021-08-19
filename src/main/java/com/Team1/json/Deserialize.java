package com.Team1.json;

import com.Team1.hibernate.model.AveragedWeatherData;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deserialize {

    public static AveragedWeatherData deserializeDataFromJson(String response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return   objectMapper.readValue(response, AveragedWeatherData.class);
    }
}
