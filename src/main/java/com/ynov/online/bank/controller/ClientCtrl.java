package com.ynov.online.bank.controller;// Created on 15/10/2017.

import com.ynov.online.bank.model.Client;

import javax.persistence.TypedQuery;
import java.util.List;


public class ClientCtrl extends AbstractControllerResource {

    public List getAll() {
        return getEntityManagerFactory().createEntityManager().createQuery("from Client").getResultList();
    }

    public Client getWithId(int resourceId) {
        TypedQuery<Client> q = getEntityManagerFactory().createEntityManager().createQuery("from Client where resourceId = ?1", Client.class);
        q.setParameter(1, resourceId);
        return q.getSingleResult();
    }

    public Client create(Client c) {
        getEntityManagerFactory().createEntityManager().getTransaction().begin();
        getEntityManagerFactory().createEntityManager().persist(c);
        getEntityManagerFactory().createEntityManager().getTransaction().commit();
        return c;
    }

    public Client update(Client a) throws Exception {
        Client verify = getWithId(a.getResourceId());
        if (verify != null) {
            TypedQuery<Client> q = getEntityManagerFactory().createEntityManager().createQuery("update Client set firstname = ?2, lastname = ?3, password = ?4 where resourceId = ?1", Client.class);
            q.setParameter(1, a.getResourceId());
            if (!a.getFirstName().isEmpty()) {
                q.setParameter(2, a.getFirstName());
            }
            if (!a.getLastName().isEmpty()) {
                q.setParameter(3, a.getLastName());
            }
            if (!a.getPassword().isEmpty()) {
                q.setParameter(4, a.getPassword());
            }
            
        } else {
            throw new Exception("This account doesn't exist");
        }
        return a;
    }

    public Client login(String login, String password) throws Exception {
        TypedQuery<Client> q = getEntityManagerFactory().createEntityManager().createQuery("from Client where login = ?1 and password = ?2", Client.class);
        q.setParameter(1, login);
        q.setParameter(2, password);
        if (q.getResultList().isEmpty()) {
            throw new Exception("Login credentials are incorrect");
        }
        return q.getSingleResult();
    }

    public boolean isLoginAvailable(String login) {
        TypedQuery<Client> q = getEntityManagerFactory().createEntityManager().createQuery("from Client where login = ?1", Client.class);
        q.setParameter(1, login);
        List<Client> results = q.getResultList();
        return results.isEmpty();
    }
}
