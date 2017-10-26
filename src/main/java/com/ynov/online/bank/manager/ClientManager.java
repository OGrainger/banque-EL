package com.ynov.online.bank.manager;// Created on 15/10/2017.

import com.ynov.online.bank.model.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class ClientManager extends AbstractManagerResource {

    private static Logger logger = LogManager.getLogger(ClientManager.class);

    // http://jmdoudoux.developpez.com/cours/developpons/java/chap-jpa.php

    public Client selectWithId(int resourceId) {
        TypedQuery<Client> q = getEntityManagerFactory().createEntityManager().createQuery("from Client where resourceId = ?1", Client.class);
        q.setParameter(1, resourceId);
        Client r = q.getSingleResult();
        logger.info("GOT CLIENT : ", r);
        return r;
    }

    public Client create(Client c) {

        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(c);
        t.commit();
        em.close();
        logger.info("CREATED CLIENT : ", c);
        return c;
    }

    public Client update(Client updatedClient) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();

        TypedQuery<Client> q =  em.createQuery("from Client where resourceId = ?1", Client.class);
        q.setParameter(1, updatedClient.getResourceId());
        Client client = q.getSingleResult();
        if (client == null) {
            logger.info("NO CLIENT FOUND FOR UPDATE : ", updatedClient);
            return null;
        } else {
            if (!updatedClient.getFirstName().isEmpty()) {
                client.setFirstName(updatedClient.getFirstName());
            }
            if (!updatedClient.getLastName().isEmpty()) {
                client.setLastName(updatedClient.getLastName());
            }
            em.flush();
            client = q.getSingleResult();
            t.commit();
            em.close();
            logger.info("UPDATED CLIENT : ", client);
            return client;
        }
    }

    public Client login(String login, String password) {
        TypedQuery<Client> q = getEntityManagerFactory().createEntityManager().createQuery("from Client where login = ?1 and password = ?2", Client.class);
        q.setParameter(1, login);
        q.setParameter(2, password);
        try {
            Client c = q.getSingleResult();
            logger.info("LOGGED IN : ", c);
            return c;
        } catch (Exception e) {
            logger.info("CREDENTIALS ARE INCORRECT : " + login + ", " + password);
            return null;
        }
    }

    public boolean isLoginAvailable(String login) {
        TypedQuery<Client> q = getEntityManagerFactory().createEntityManager().createQuery("from Client where login = ?1", Client.class);
        q.setParameter(1, login);
        try {
            List<Client> results = q.getResultList();
            logger.info("LOGIN NOT AVAILABLE : ", login);
            return results.isEmpty();
        } catch (Exception e) {
            logger.info("LOGIN AVAILABLE : ", login);
            return true;
        }
    }
}
