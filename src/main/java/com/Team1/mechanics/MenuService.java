package com.Team1.mechanics;

import com.Team1.dto.AccuweatherResponse;
import com.Team1.dto.OpenWeatherResponse;
import com.Team1.json.DeserializeAccuweatherResponse;
import com.Team1.json.DeserializeOpenweatherResponse;
import com.Team1.json.DeserializeWeatherstackResponse;
import com.Team1.weatherservicerecords.AccuweatherService;
import com.Team1.weatherservicerecords.OpenweatherService;
import com.Team1.weatherservicerecords.WeatherstackService;
import okhttp3.Response;

import java.io.IOException;
import java.util.Scanner;

public class MenuService {

    public void performActionSelectedByUser(int userChoice) throws IOException {
        switch (userChoice) {
            case 1:
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

//                accuweatherService.createBaseUrl(cityName);
//                Response accuweatherResponseForCityKey = accuweatherService.getResponseFromAcuweather();
//                DeserializeAccuweatherResponse deserializeAccuweatherResponse = new DeserializeAccuweatherResponse();
//             //   AccuweatherResponse cityKey = deserializeAccuweatherResponse.deserializeAccuweatherresponse(accuweatherResponseForCityKey.body().string().toString());
             //   System.out.println(cityKey);
////
//                accuweatherService.createUrlByCityKey("2696858");
//                Response accuweatherResponseByCityKey = accuweatherService.getResponseByCityKeyFromAcuweather();
//                System.out.println(accuweatherResponseByCityKey.body().string());

                openweatherService.createBaseUrl(cityName);
                Response openweatherResponse = openweatherService.getResponseFromOpenweather();
                DeserializeOpenweatherResponse deserializedOpenweatherResponse  = new DeserializeOpenweatherResponse();
                System.out.println(openweatherResponse.body().string());






                //  AveragedWeatherData averagedWeatherData =Deserialize.deserializeDataFromJson(accuweatherService.getResponseFromAcuweather().toString()); // to przekazać String ze zmienionego Jasona
                //   System.out.println(averagedWeatherData.toString());
                //    AveregedWeatherDataRepository averegedWeatherDataRepository = new AveregedWeatherDataRepository();
                //    averegedWeatherDataRepository.printRealTimeWeatherData(averagedWeatherData);
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
