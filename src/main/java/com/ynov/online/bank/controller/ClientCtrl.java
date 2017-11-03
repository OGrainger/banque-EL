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

    private final String numbersAndAlphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String numbers = "0123456789";

    private final int numbersAndAlphabetLength = numbersAndAlphabet.length();
    private final int numbersLength = numbers.length();

    private Random random = new Random();

    public void createClientWithAnAccount(Client client) {

        clientManager.create(client);

        Account a = new Account();
        a.setIban(generateIBAN());
        a.setClient(client);
        a.setBalance(100);
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

    private String generateIBAN() {
        StringBuilder iban = new StringBuilder();
        iban.append( "FR333020");
        for (int i = 0; i < 5; i++) {
            iban.append(numbers.charAt(random.nextInt(numbersLength)));
        }
        for (int i = 0; i < 11; i++) {
            iban.append(numbersAndAlphabet.charAt(random.nextInt(numbersAndAlphabetLength)));
        }
        for (int i = 0; i < 2; i++) {
            iban.append(numbers.charAt(random.nextInt(numbersLength)));
        }

        return iban.toString();
    }
}
