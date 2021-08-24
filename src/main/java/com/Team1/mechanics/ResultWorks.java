package com.Team1.mechanics;

import com.Team1.dto.AccuResponse.AccuweatherResponse;
import com.Team1.dto.AccuResponse.AccuweatherResponseByKey;
import com.Team1.dto.OpenResponse.OpenWeatherResponse;
import com.Team1.dto.weatherstack.WeatherstackResponse;
import com.Team1.hibernate.DataBaseWorks;
import com.Team1.json.DeserializeAccuweatherResponse;
import com.Team1.json.DeserializeAccuweatherResponseByKey;
import com.Team1.json.DeserializeOpenweatherResponse;
import com.Team1.json.DeserializeWeatherstackResponse;
import com.Team1.weatherservicerecords.AccuweatherService;
import com.Team1.weatherservicerecords.OpenweatherService;
import com.Team1.weatherservicerecords.WeatherstackService;
import okhttp3.Response;
import org.hibernate.SessionFactory;

import java.io.IOException;

public class ResultWorks {
    AccuweatherResponseByKey accuweatherDataResponse;
    WeatherstackResponse weatherstackDataResponse;
    OpenWeatherResponse openWeatherDataResponse;
    double avgTemp;
    double avgHumidity;
    double avgWindDir;
    double avgPressure;
    double avgWindSpeed;

    public void showAndSaveResultQuery(String cityname) throws IOException {
        getResultsFromQuery(cityname);
        printAvgData();
        saveDataToDatabase(cityname);
    }

    private void getResultsFromQuery(String cityname) throws IOException {
        accuweatherDataResponse = getResultFromAccuweather(cityname);
        weatherstackDataResponse = getResultFromWeatherstack(cityname);
        openWeatherDataResponse = getResultFromOpenweather(cityname);
    }

    private AccuweatherResponseByKey getResultFromAccuweather(String cityName) throws IOException {
        AccuweatherService accuweatherService = new AccuweatherService();

        accuweatherService.createBaseUrl(cityName);
        Response accuweatherResponseForCityKey = accuweatherService.getResponseFromAcuweather();
        DeserializeAccuweatherResponse deserializeAccuweatherResponse = new DeserializeAccuweatherResponse();
        String accuweatherJason = (accuweatherResponseForCityKey.body().string());
        String newAccuweatherJason = (accuweatherJason.substring(1, accuweatherJason.length() - 1));
        AccuweatherResponse cityKey = deserializeAccuweatherResponse.deserializeAccuweatherResponse(newAccuweatherJason);
        accuweatherService.createUrlByCityKey(cityKey.getKey());
        Response accuweatherResponseByCityKey = accuweatherService.getResponseByCityKeyFromAcuweather();
        String accuweatherJasonByKey = (accuweatherResponseByCityKey.body().string());
        String newAccuweatherJasonByKey = accuweatherJasonByKey.substring(1, accuweatherJasonByKey.length() - 1);
        DeserializeAccuweatherResponseByKey deserializedAccuweatherResponseByKey = new DeserializeAccuweatherResponseByKey();
        AccuweatherResponseByKey accuweatherResponseByKey = deserializedAccuweatherResponseByKey.deserializeAccuweatherResponseByKey(newAccuweatherJasonByKey);

        return accuweatherResponseByKey;
    }

    private WeatherstackResponse getResultFromWeatherstack(String cityName) throws IOException {
        WeatherstackService weatherstackService = new WeatherstackService();

        weatherstackService.createBaseUrl(cityName);
        Response weatherServiceResponse = weatherstackService.getResponseFromWeatherstack();
        DeserializeWeatherstackResponse deserializedWeatherstackResponse = new DeserializeWeatherstackResponse();
        WeatherstackResponse deserilisedWeatherstackResponse = (deserializedWeatherstackResponse.deserializeWeatherstackResponse(weatherServiceResponse.body().string()));
        return deserilisedWeatherstackResponse;
    }

    private OpenWeatherResponse getResultFromOpenweather(String cityName) throws IOException {
        OpenweatherService openweatherService = new OpenweatherService();

        openweatherService.createBaseUrl(cityName);
        Response openweatherResponse = openweatherService.getResponseFromOpenweather();
        DeserializeOpenweatherResponse deserializedOpenweatherResponse = new DeserializeOpenweatherResponse();
        OpenWeatherResponse deserializedOpenWeatherResponse = (deserializedOpenweatherResponse.deserializeOpenweather(openweatherResponse.body().string()));
        return deserializedOpenWeatherResponse;
    }

    private void printAvgData() {
        AverageDataCalculator dataCalculator = new AverageDataCalculator();

         avgTemp = dataCalculator.calculateAverageTemp(weatherstackDataResponse.getCurrent()
                .getTemperature(), openWeatherDataResponse.getMain()
                .getTemp(), accuweatherDataResponse.getTemperature().getMetric().getValue());

         avgHumidity = dataCalculator.calculateAverageHumidity
                (openWeatherDataResponse.getMain().getHumidity(),
                        weatherstackDataResponse.getCurrent().getHumidity(),
                        accuweatherDataResponse.getRelativeHumidity());

         avgWindDir = dataCalculator.calculateAverageWindDirection
                (openWeatherDataResponse.getWind().getDeg(),
                        weatherstackDataResponse.getCurrent().getWind_degree(),
                        accuweatherDataResponse.getWind().getDirection().getDegrees());

         avgPressure = dataCalculator.calculateAveragePressure
                (openWeatherDataResponse.getMain().getPressure(),
                        weatherstackDataResponse.getCurrent().getPressure(),
                        accuweatherDataResponse.getPressure().getMetric().getValue());

        avgWindSpeed = dataCalculator.calculateAverageWindSpeed
                (openWeatherDataResponse.getWind().getSpeed(),
                        weatherstackDataResponse.getCurrent().getWind_speed(),
                        accuweatherDataResponse.getWind().getSpeed().getMetric().getValue());

        System.out.println("Srednia temperatura: " + avgTemp);
        System.out.println("Srednia wartość ciśnienia: " + avgPressure);
        System.out.println("Srednia wilgotnoć: " + avgHumidity);
        System.out.println("Srednia prędkość wiatru: " + avgWindSpeed);
        System.out.println("Sreddna wartość kierunku wiatru w stopniach: " + avgWindDir);
    }
    private void saveDataToDatabase(String cityName){
        DataBaseWorks dataBaseWorks = new DataBaseWorks();
        SessionFactory sessionFactory = dataBaseWorks.createSessionFactory();
        dataBaseWorks.averagedWeatherDataSave(sessionFactory,avgTemp,avgPressure,avgHumidity,avgWindDir,avgWindSpeed,cityName);
    }
}
