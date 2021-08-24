package com.Team1.hibernate.repository;

import com.Team1.hibernate.model.AveragedWeatherData;
import com.Team1.hibernate.model.Localisation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;
import java.util.List;

public class AveregedWeatherDataRepository {
    private final EntityManager entityManager;

//    public AveregedWeatherDataRepository(){
//    }

    public AveregedWeatherDataRepository(EntityManager entityManager) {
        if (entityManager == null) {
            throw new IllegalArgumentException("EntityManager is null!");
        }
        this.entityManager = entityManager;
    }

    public void saveRealTimeWeatherData(AveragedWeatherData averagedWeatherData){
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(averagedWeatherData);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void printRealTimeWeatherData(AveragedWeatherData averagedWeatherData){
        System.out.println(averagedWeatherData.toString());
    }

    public List<AveragedWeatherData> printAllSavedWeatherDateForLocalisation( LocalDate date){
        return entityManager.createQuery("FROM AveragedWeatherData WHERE date  = :date  ", AveragedWeatherData.class)
                .setParameter("date", date)
                .getResultList();
    }

}
