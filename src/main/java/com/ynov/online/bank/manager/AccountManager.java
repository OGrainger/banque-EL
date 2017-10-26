package com.ynov.online.bank.manager;// Created on 15/10/2017.

import com.ynov.online.bank.model.Account;

import javax.persistence.TypedQuery;
import java.util.List;


public class AccountManager extends AbstractManagerResource {


    public Account selectWithId(int resourceId) {
        TypedQuery<Account> q = getEntityManagerFactory().createEntityManager().createQuery("from Account where resourceId = ?1", Account.class);
        q.setParameter(1, resourceId);
        return q.getSingleResult();
    }

    public Account create(Account a) {
        getEntityManagerFactory().createEntityManager().getTransaction().begin();
        getEntityManagerFactory().createEntityManager().persist(a);
        getEntityManagerFactory().createEntityManager().getTransaction().commit();
        return a;
    }

    public Account delete(Account a) throws Exception {
        Account verify = selectWithId(a.getResourceId());
        if (verify != null) {
            TypedQuery<Account> q = getEntityManagerFactory().createEntityManager().createQuery("delete from Account where resourceId = ?1", Account.class);
            q.setParameter(1, a.getResourceId());
        } else {
            throw new Exception("This account doesn't exist");
        }
        return a;
    }

    public Account update(Account a) throws Exception {
        Account verify = selectWithId(a.getResourceId());
        if (verify != null) {
            TypedQuery<Account> q = getEntityManagerFactory().createEntityManager().createQuery("update Account set description = ?2 where resourceId = ?1", Account.class);
            q.setParameter(1, a.getResourceId());
            q.setParameter(2, a.getDescription());
        } else {
            throw new Exception("This account doesn't exist");
        }
        return a;
    }
}
