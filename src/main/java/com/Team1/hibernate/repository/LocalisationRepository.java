package com.Team1.hibernate.repository;

import com.Team1.hibernate.model.Localisation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class LocalisationRepository {
    private  EntityManager entityManager;

    public LocalisationRepository(EntityManager entityManager) {
        if (entityManager == null) {
            throw new IllegalArgumentException("EntityManager is null!");
        }
        this.entityManager = entityManager;
    }

    public void saveNewLocation(Localisation localisation){
            EntityTransaction transaction = null;
            try {
                transaction = entityManager.getTransaction();
                transaction.begin();
                entityManager.persist(localisation);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
        }

    public List<Localisation> findAllLocalisations() {
        return entityManager.createQuery("FROM Localisation", Localisation.class).getResultList();
    }
}
