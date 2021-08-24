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
                break;
            case 3:
                Scanner sc = new Scanner(System.in);
                System.out.println("Podaj nazwę miejscowści");
                String cityName = sc.nextLine();
                ResultWorks resultWorks = new ResultWorks();
                resultWorks.showAndSaveResultQuery(cityName);
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
