package com.Team1.hibernate;

import com.Team1.hibernate.model.AveragedWeatherData;
import com.Team1.hibernate.model.Localisation;
import com.Team1.hibernate.repository.AveregedWeatherDataRepository;
import com.Team1.hibernate.repository.LocalisationRepository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataBaseWorks {
    public void createSessionFactory() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(AveragedWeatherData.class)
                .addAnnotatedClass(Localisation.class)
                .buildSessionFactory();
    }
}
