package com.Team1.json;

import com.Team1.dto.AccuResponse.AccuweatherResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializeAccuweatherResponse {

    public AccuweatherResponse deserializeAccuweatherResponse(String accuweatherJson) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        AccuweatherResponse accuweatherResponse = objectMapper.readValue(accuweatherJson, AccuweatherResponse.class);;
        return accuweatherResponse;
    }
}
