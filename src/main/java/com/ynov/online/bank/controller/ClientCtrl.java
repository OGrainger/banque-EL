package com.ynov.online.bank.controller;// Created on 26/10/2017.

import com.ynov.online.bank.manager.AccountManager;
import com.ynov.online.bank.manager.ClientManager;
import com.ynov.online.bank.model.Account;
import com.ynov.online.bank.model.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Random;

public class ClientCtrl {

    private static Logger logger = LogManager.getLogger(ClientCtrl.class);

    private static ClientManager clientManager = new ClientManager();
    private static AccountManager accountManager = new AccountManager();
    private final String alphabet = "0123456789ABCDEF ";
    private final int N = alphabet.length();
    private Random random = new Random();

    public void createClientWithAnAccount(Client client) {

        clientManager.create(client);

        Account a = new Account();
        StringBuilder iban = new StringBuilder();
        a.setBalance(100);
        for (int i = 0; i < 18; i++) {
            iban.append(alphabet.charAt(random.nextInt(N)));
        }
        a.setIban(iban.toString());
        a.setClient(client);
        a.setDescription("Compte courant");
        accountManager.create(a);
        logger.info("CREATED CLIENT " + client.getLogin() + " WITH BONUS ACCOUNT");
    }

    public Client login(String login, String password) {
        return clientManager.selectWithLoginAndPassword(login, password);
    }

    public boolean isLoginAvailable(String login) {
        List<Client> clients = clientManager.selectAllWithLogin(login);
        logger.info("LOGIN " + login + " IS " + (clients.isEmpty() ? "" : "NOT ") + "AVAILABLE");
        return clients.isEmpty();
    }
}
