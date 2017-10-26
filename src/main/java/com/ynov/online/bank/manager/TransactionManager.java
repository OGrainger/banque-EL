package com.ynov.online.bank.manager;// Created on 15/10/2017.

import com.ynov.online.bank.model.Account;
import com.ynov.online.bank.model.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class TransactionManager extends AbstractManagerResource {

    public List<Transaction> getAll() {
        return getEntityManagerFactory().createEntityManager().createQuery("from Transaction").getResultList();
    }

    public Transaction getWithId(int resourceId) {
        TypedQuery<Transaction> q = getEntityManagerFactory().createEntityManager().createQuery("from Transaction where resourceId = ?1", Transaction.class);
        q.setParameter(1, resourceId);
        return q.getSingleResult();
    }

    public List<Transaction> getTransactionsFromRecipientAccount(Account account) {
        TypedQuery<Transaction> q = getEntityManagerFactory().createEntityManager().createQuery("from Transaction where recipientAccount.id = ?1", Transaction.class);
        q.setParameter(1, account.getResourceId());
        return q.getResultList();
    }

    public List<Transaction> getTransactionsFromDonorAccount(Account account) {
        TypedQuery<Transaction> q = getEntityManagerFactory().createEntityManager().createQuery("from Transaction where donorAccount.id = ?1", Transaction.class);
        q.setParameter(1, account.getResourceId());
        return q.getResultList();
    }

    public Transaction create(Transaction c) {
        getEntityManagerFactory().createEntityManager().getTransaction().begin();
        getEntityManagerFactory().createEntityManager().persist(c);
        getEntityManagerFactory().createEntityManager().getTransaction().commit();
        return c;
    }
}
