package com.Team1.json;

import com.Team1.dto.AccuweatherResponse;
import com.Team1.hibernate.model.AveragedWeatherData;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;

public class DeserializeAccuweatherResponse {

    public AccuweatherResponse deserializeAccuweatherresponse(String accuweatherJason) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
     AccuweatherResponse accuweatherResponse = objectMapper.readValue(accuweatherJason, AccuweatherResponse.class);
        System.out.println(accuweatherResponse);
        return accuweatherResponse;
    }
}
