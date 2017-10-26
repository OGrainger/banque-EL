package com.ynov.online.bank.manager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public abstract class AbstractManagerResource {

    private static final String PERSISTENCE_UNIT_NAME = "online-bank";
    private static EntityManagerFactory entityManagerFactory;

    protected EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactory;
    }

    protected void closeConnection() {
        entityManagerFactory.close();
    }
}
