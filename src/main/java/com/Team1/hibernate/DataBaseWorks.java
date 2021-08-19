package com.Team1.hibernate;

import com.Team1.hibernate.model.AveragedWeatherData;
import com.Team1.hibernate.model.Localisation;
import com.Team1.hibernate.repository.AveregedWeatherDataRepository;
import com.Team1.hibernate.repository.LocalisationRepository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DataBaseWorks {
    public void createSessionFactory() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(AveragedWeatherData.class)
                .addAnnotatedClass(Localisation.class)
                .buildSessionFactory();

        localisationQueries(sessionFactory);
 //       averagedWeatherDataQueries(sessionFactory);
    }

    public void localisationQueries(SessionFactory sessionFactory){
        LocalisationRepository localisation = new LocalisationRepository(sessionFactory.createEntityManager());

        localisation.saveNewLocation(new Localisation("21W32N","Mazowieckie","Warszawa","Polska"));
        localisation.saveNewLocation(new Localisation("25W39N","Śląskie","Katowice","Polska"));
        localisation.saveNewLocation(new Localisation("65W75N","Małopolskie","Kraków","Polska"));

        List<Localisation> listOfLocalisations = localisation.findAllLocalisations();
        for (Localisation localisationFromList : listOfLocalisations) {
            System.out.println(localisationFromList.toString());
        }
    }


    public void averagedWeatherDataQueries(SessionFactory sessionFactory){
        AveregedWeatherDataRepository weatherDataRepository = new AveregedWeatherDataRepository(sessionFactory.createEntityManager());
        weatherDataRepository.saveRealTimeWeatherData(new AveragedWeatherData(LocalDate.of(1999,12,9),-5,1010,65,"E",16,1l));
        weatherDataRepository.saveRealTimeWeatherData(new AveragedWeatherData(LocalDate.of(2001,8,15),23,1005,88,"W",20,2l));
        weatherDataRepository.saveRealTimeWeatherData(new AveragedWeatherData(LocalDate.of(1010,1,25),-15,1015,72,"SW",12,3l));

        weatherDataRepository.printRealTimeWeatherData(new AveragedWeatherData(LocalDate.of(1999,12,9),-5,1010,65,"E",16,1l));

       List<AveragedWeatherData> weatherDataFromList =  weatherDataRepository.printAllSavedWeatherDateForLocalisation("Warszawa",LocalDate.of(1999,12,9));
        for (AveragedWeatherData weatherData : weatherDataFromList) {
            System.out.println("Dane pogodowe dla Wa-wy z dnia 09.12.1999: "+weatherData.toString());
        }

    }
}
