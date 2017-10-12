package com.ynov.banqueEL;


import com.ynov.banqueEL.model.Account;
import com.ynov.banqueEL.model.Client;
import com.ynov.banqueEL.model.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class TestJPA {

    private static final String PERSISTENCE_UNIT_NAME = "banque-EL";
    private static EntityManagerFactory factory;

    private static Logger logger = LogManager.getLogger(TestJPA.class);

    public static void main(String[] args) {

        try {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();
/*

            Client client = new Client();
            client.setLogin("dummy");
            client.setPassword("pass");
            client.setFirstName("fn");
            client.setLastName("ln");

            List<Account> accounts = new ArrayList<>();
            Account a = new Account();
            a.setDescription("dummy account a");
            a.setMoney(42);
            a.setClient(client);
            accounts.add(a);

            Account b = new Account();
            b.setMoney(10);
            b.setDescription("dummy account b");
            b.setClient(client);

            Transaction transaction = new Transaction();
            transaction.setDescription("transaction test");
            transaction.setCreditorAccount(a);
            transaction.setDebtorAccount(b);
            transaction.setAmount(10);

            List<Transaction> transactions = new ArrayList<>();
            transactions.add(transaction);

            b.setDebtorTransactions(transactions);

            accounts.add(b);



            client.setAccounts(accounts);


            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
            logger.info("NEW CLIENT : " + client.toString());*/


            /*TypedQuery<Client> tQuery = em.createQuery("from Client", Client.class);
            List<Client> clientList = tQuery.getResultList();

            PersistenceUtil util = Persistence.getPersistenceUtil();

            for (Client c : clientList) {
                logger.info("GET CLIENT : " + c.getClientID());
                c.getAccounts().forEach(a -> {
                    logger.info("GET ACCOUNT : " + a.getNumber());
                });
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
