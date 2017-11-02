package com.ynov.online.bank.manager;// Created on 15/10/2017.

import com.ynov.online.bank.model.Account;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class AccountManager extends AbstractManagerResource {

    private static Logger logger = LogManager.getLogger(AccountManager.class);

    public Account selectWithId(String id) {
        Account a = getEntityManagerFactory().createEntityManager().find(Account.class, Integer.parseInt(id));
        logger.info("GOT ACCOUNT : " + a);
        return a;
    }

    public Account create(Account a) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(a);
        t.commit();
        em.close();
        logger.info("CREATED ACCOUNT : " + a);
        return a;
    }
}
