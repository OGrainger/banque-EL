package com.ynov.banqueEL;


import com.ynov.banqueEL.model.Account;
import com.ynov.banqueEL.model.Client;
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

            List<Account> accounts = new ArrayList<>();
            Account a = new Account();
            a.setDescription("dummy account");
            a.setMoney(42);
            accounts.add(a);

            Client client = new Client();
            client.setLogin("dummy");
            client.setPassword("pass");
            client.setFirstName("fn");
            client.setLastName("ln");
            client.setAccounts(accounts);

            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
            logger.info("NEW CLIENT : " + client.toString());


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
