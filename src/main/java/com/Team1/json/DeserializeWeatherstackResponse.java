package com.Team1.json;

import com.Team1.dto.weatherstack.WeatherstackResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializeWeatherstackResponse {
    public WeatherstackResponse deserializeWeatherstackResponse(String weatherstackJason) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
       WeatherstackResponse weatherstackResponse = objectMapper.readValue(weatherstackJason, WeatherstackResponse.class);
        return weatherstackResponse;
    }
}
