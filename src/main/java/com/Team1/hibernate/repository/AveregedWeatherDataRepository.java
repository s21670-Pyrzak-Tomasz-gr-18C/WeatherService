package com.Team1.hibernate.repository;

import javax.persistence.EntityManager;

public class AveregedWeatherDataRepository {
    private final EntityManager entityManager;

    public AveregedWeatherDataRepository(EntityManager entityManager) {
        if (entityManager == null) {
            throw new IllegalArgumentException("EntityManager is null!");
        }
        this.entityManager = entityManager;
    }
}
