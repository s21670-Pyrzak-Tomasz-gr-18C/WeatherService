package com.Team1.mechanics;

import com.Team1.dto.AccuweatherResponse;
import com.Team1.hibernate.DataBaseWorks;
import com.Team1.json.DeserializeAccuweatherResponse;
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
                System.out.println("wybrałeś2");
                break;
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
                System.out.println(deserializedWeatherstackResponse.deserializeWeatherstackResponse(weatherServiceResponse.body().string()).toString());

                accuweatherService.createBaseUrl(cityName);
                Response accuweatherResponseForCityKey = accuweatherService.getResponseFromAcuweather();
                DeserializeAccuweatherResponse deserializeAccuweatherResponse = new DeserializeAccuweatherResponse();
                String AccuweatherJason = (accuweatherResponseForCityKey.body().string());
                AccuweatherResponse cityKey = deserializeAccuweatherResponse.deserializeAccuweatherResponse(AccuweatherJason);
                System.out.println(cityKey.getKey());

                accuweatherService.createUrlByCityKey("2696858");
                Response accuweatherResponseByCityKey = accuweatherService.getResponseByCityKeyFromAcuweather();
                System.out.println(accuweatherResponseByCityKey.body().string());

                openweatherService.createBaseUrl(cityName);
                Response openweatherResponse = openweatherService.getResponseFromOpenweather();
                DeserializeOpenweatherResponse deserializedOpenweatherResponse = new DeserializeOpenweatherResponse();
                System.out.println(deserializedOpenweatherResponse.deserializeOpenweather(openweatherResponse.body().string()));

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
