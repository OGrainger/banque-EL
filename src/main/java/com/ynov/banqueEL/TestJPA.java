package com.ynov.banqueEL;


import com.ynov.banqueEL.model.Client;

import javax.persistence.*;
import java.sql.Connection;
import java.util.List;

public class TestJPA {

    private static final String PERSISTENCE_UNIT_NAME = "banque-EL";
    private static EntityManagerFactory factory;


    public static void main(String[] args) {
        // Persistence.generateSchema(PERSISTENCE_UNIT_NAME, null);

        EntityManager em = null;
        try {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            em = factory.createEntityManager();

            TypedQuery<Client> tQuery = em.createQuery("from Client", Client.class);
            List<Client> clientList = tQuery.getResultList();

            PersistenceUtil util = Persistence.getPersistenceUtil();

            for (Client c : clientList) {
                System.out.println(c.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
