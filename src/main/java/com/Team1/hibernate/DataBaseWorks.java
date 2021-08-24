package com.Team1.hibernate;

import com.Team1.hibernate.model.AveragedWeatherData;
import com.Team1.hibernate.model.Localisation;
import com.Team1.hibernate.repository.AveregedWeatherDataRepository;
import com.Team1.hibernate.repository.LocalisationRepository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class DataBaseWorks {
    public SessionFactory createSessionFactory() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(AveragedWeatherData.class)
                .addAnnotatedClass(Localisation.class)
                .buildSessionFactory();
        return sessionFactory;

    }
    public void createNewLocalisation(SessionFactory sessionFactory){
        Scanner scanner = new Scanner(System.in);
        LocalisationRepository localisation = new LocalisationRepository(sessionFactory.createEntityManager());
        System.out.println("Podaj współrzędne: ");
        String geographicCoordinates = scanner.nextLine();
        System.out.println("Podaj nazwę regionu: ");
        String region = scanner.nextLine();
        System.out.println("Podaj nazwę lokalizacji: ");
        String name = scanner.nextLine();
        System.out.println("Podaj nazwe kraju: ");
        String country = scanner.nextLine();

        localisation.saveNewLocation(new Localisation(geographicCoordinates,region,name,country));
    }

    public void showAllLocalisations(SessionFactory sessionFactory){
        LocalisationRepository localisation = new LocalisationRepository(sessionFactory.createEntityManager());
        List<Localisation> listOfLocalisations = localisation.findAllLocalisations();
        for (Localisation localisationFromList : listOfLocalisations) {
            System.out.println(localisationFromList.toString());
        }
    }


    public void averagedWeatherDataSave(SessionFactory sessionFactory,double avgTemp,double avgPressure, double avgHumidity,double avgWindDirection, double avgWindSpeed,String localisationName){
        AveregedWeatherDataRepository weatherDataRepository = new AveregedWeatherDataRepository(sessionFactory.createEntityManager());
        weatherDataRepository.saveRealTimeWeatherData(new AveragedWeatherData(LocalDate.now(),avgTemp,avgPressure,avgHumidity,avgWindDirection,avgWindSpeed,localisationName));

   }
}
