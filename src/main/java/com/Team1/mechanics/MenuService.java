package com.Team1.mechanics;

import com.Team1.hibernate.DataBaseWorks;
import com.Team1.hibernate.model.AveragedWeatherData;
import com.Team1.hibernate.repository.AveregedWeatherDataRepository;
import com.Team1.json.Deserialize;
import com.Team1.weatherservicerecords.AccuweatherService;
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
//                try (Response response = accuweatherService.getResponseFromAcuweather()) {
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
                AveragedWeatherData averagedWeatherData =Deserialize.deserializeDataFromJson(accuweatherService.getResponseFromAcuweather().toString());
                System.out.println(averagedWeatherData.toString());
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
