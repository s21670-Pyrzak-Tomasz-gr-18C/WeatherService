package com.Team1.json;

import com.Team1.dto.OpenResponse.OpenWeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializeOpenweatherResponse {

        public OpenWeatherResponse deserializeOpenweather(String openweatherJason) throws JsonProcessingException {
            System.out.println(openweatherJason);
            ObjectMapper objectMapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            OpenWeatherResponse openWeatherResponse = objectMapper.readValue(openweatherJason, OpenWeatherResponse.class);

            return openWeatherResponse;

    }

}
