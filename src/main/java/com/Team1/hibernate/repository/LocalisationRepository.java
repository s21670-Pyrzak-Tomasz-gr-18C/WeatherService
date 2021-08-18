package com.Team1.hibernate.repository;

import javax.persistence.EntityManager;

public class LocalisationRepository {
    private final EntityManager entityManager;

    public LocalisationRepository(EntityManager entityManager) {
        if (entityManager == null) {
            throw new IllegalArgumentException("EntityManager is null!");
        }
        this.entityManager = entityManager;
    }
}
