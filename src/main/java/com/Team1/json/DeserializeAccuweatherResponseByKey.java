package com.Team1.json;


import com.Team1.dto.AccuResponse.AccuweatherResponseByKey;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializeAccuweatherResponseByKey {

    public AccuweatherResponseByKey deserializeAccuweatherResponseByKey(String accuweatherJson) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        AccuweatherResponseByKey accuweatherResponseByKey = objectMapper.readValue(accuweatherJson, AccuweatherResponseByKey.class);
        return accuweatherResponseByKey;
    }
}
