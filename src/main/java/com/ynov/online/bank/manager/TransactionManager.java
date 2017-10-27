package com.ynov.online.bank.manager;// Created on 15/10/2017.

import com.ynov.online.bank.model.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class TransactionManager extends AbstractManagerResource {

    private static Logger logger = LogManager.getLogger(TransactionManager.class);

    public Transaction selectWithId(String id) {
        Transaction t = getEntityManagerFactory().createEntityManager().find(Transaction.class, Integer.parseInt(id));
        logger.info("GOT TRANSACTION : " + t);
        return t;
    }

    public List<Transaction> getTransactionsFromRecipientAccountId(String id) {
        TypedQuery<Transaction> q = getEntityManagerFactory().createEntityManager().createQuery("from Transaction where recipientAccount.id = ?1", Transaction.class);
        q.setParameter(1, Integer.parseInt(id));
        List<Transaction> l = q.getResultList();
        logger.info("GOT TRANSACTIONS FROM RECIPIENT : " + id);
        return l;
    }

    public List<Transaction> getTransactionsFromDonorAccountId(String id) {
        TypedQuery<Transaction> q = getEntityManagerFactory().createEntityManager().createQuery("from Transaction where donorAccount.id = ?1", Transaction.class);
        q.setParameter(1, Integer.parseInt(id));
        List<Transaction> l = q.getResultList();
        logger.info("GOT TRANSACTIONS FROM DONOR : " + id);
        return l;
    }

    public Transaction create(Transaction tr) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(tr);
        t.commit();
        em.close();
        logger.info("CREATED TRANSACTION : " + tr);
        return tr;
    }
}
