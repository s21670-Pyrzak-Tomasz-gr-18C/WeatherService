package com.Team1.json;

import com.Team1.dto.OpenWeatherResponse;
import com.Team1.dto.WeatherstackResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializeOpenweatherResponse {

        public OpenWeatherResponse deserializeOpenweather(String openweatherJason) throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            OpenWeatherResponse openWeatherResponse = objectMapper.readValue(openweatherJason, OpenWeatherResponse.class);
            System.out.println("to jest open: \n"+openWeatherResponse.toString());
            return openWeatherResponse;

    }

}
