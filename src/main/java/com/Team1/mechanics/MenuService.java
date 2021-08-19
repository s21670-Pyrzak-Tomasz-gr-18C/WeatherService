package com.Team1.mechanics;

import com.Team1.json.DeserializeAccuweatherResponse;
import com.Team1.weatherservicerecords.AccuweatherService;
import com.fasterxml.jackson.databind.util.JSONPObject;
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
                AccuweatherService accuweatherService = new AccuweatherService();

                accuweatherService.createBaseUrl(sc.nextLine());
                Response response = accuweatherService.getResponseFromAcuweather();
                String jason = response.body().string();

                System.out.println(jason);


              //  DeserializeAccuweatherResponse deserializeAccuweatherResponse = new DeserializeAccuweatherResponse();
              //  String cityKey = deserializeAccuweatherResponse.deserializeAccuweatherresponse(jason).getCityKey();

              //  System.out.println(cityKey);

                //accuweatherService.createUrlByCityKey("2696858");
                //Response responseByCityKey = accuweatherService.getResponseByCityKeyFromAcuweather();
                //System.out.println(responseByCityKey.body().string());



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
