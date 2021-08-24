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
import java.util.Scanner;

public class MenuService {

    public void performActionSelectedByUser(int userChoice) throws IOException {
        switch (userChoice) {
            case 1:
                DataBaseWorks dataBaseWorks = new DataBaseWorks();
                SessionFactory sessionFactory = dataBaseWorks.createSessionFactory();
                dataBaseWorks.createNewLocalisation(sessionFactory);
                break;
            case 2:
                DataBaseWorks dataBaseWorks1 = new DataBaseWorks();
                SessionFactory sessionFactory1 = dataBaseWorks1.createSessionFactory();
                dataBaseWorks1.showAllLocalisations(sessionFactory1);
            case 3:
                Scanner sc = new Scanner(System.in);
                System.out.println("Podaj nazwę miejscowści");
                String cityName = sc.nextLine();
                AccuweatherService accuweatherService = new AccuweatherService();
                WeatherstackService weatherstackService = new WeatherstackService();
                OpenweatherService openweatherService = new OpenweatherService();

                weatherstackService.createBaseUrl(cityName);
                Response weatherServiceResponse = weatherstackService.getResponseFromWeatherstack();
                DeserializeWeatherstackResponse deserializedWeatherstackResponse = new DeserializeWeatherstackResponse();
                WeatherstackResponse deserilisedWeatherstackResponse = (deserializedWeatherstackResponse.deserializeWeatherstackResponse(weatherServiceResponse.body().string()));


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



                openweatherService.createBaseUrl(cityName);
                Response openweatherResponse = openweatherService.getResponseFromOpenweather();
                DeserializeOpenweatherResponse deserializedOpenweatherResponse = new DeserializeOpenweatherResponse();
                OpenWeatherResponse deserializedOpenWeatherResponse = (deserializedOpenweatherResponse.deserializeOpenweather(openweatherResponse.body().string()));

                AverageDataCalculator dataCalculator = new AverageDataCalculator();


                dataCalculator.calculateAverageTemp(deserilisedWeatherstackResponse.getCurrent().getTemperature(), deserializedOpenWeatherResponse.getMain().getTemp(),accuweatherResponseByKey.getTemperature().getMetric().getValue());
                dataCalculator.calculateAverageHumidity(deserializedOpenWeatherResponse.getMain().getHumidity(), deserilisedWeatherstackResponse.getCurrent().getHumidity(),accuweatherResponseByKey.getRelativeHumidity());
                dataCalculator.calculateAverageWindDirection(deserializedOpenWeatherResponse.getWind().getDeg(), deserilisedWeatherstackResponse.getCurrent().getWind_degree(),accuweatherResponseByKey.getWind().getDirection().getDegrees());
                dataCalculator.calculateAveragePressure(deserializedOpenWeatherResponse.getMain().getPressure(),deserilisedWeatherstackResponse.getCurrent().getPressure(),accuweatherResponseByKey.getPressure().getMetric().getValue());
                dataCalculator.calculateAverageWindSpeed(deserializedOpenWeatherResponse.getWind().getSpeed(),deserilisedWeatherstackResponse.getCurrent().getWind_speed(),accuweatherResponseByKey.getWind().getSpeed().getMetric().getValue());
                break;
            case 4:
                System.out.println("wybrałeś4");
                break;
            default:
                System.out.println("niepoprawny wybór");
                break;
        }
    }
}
