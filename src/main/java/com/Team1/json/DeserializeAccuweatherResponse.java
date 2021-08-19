package com.Team1.json;

import com.Team1.dto.AccuweatherResponse;
import com.Team1.hibernate.model.AveragedWeatherData;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializeAccuweatherResponse {

    public AccuweatherResponse deserializeAccuweatherresponse(String jason) throws JsonProcessingException {

        System.out.println(jason);
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
     AccuweatherResponse accuweatherResponse = objectMapper.readValue(jason, AccuweatherResponse.class);
        System.out.println(accuweatherResponse);
        return accuweatherResponse;
    }
}
