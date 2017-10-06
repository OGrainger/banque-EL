package com.ynov.banqueEL;


import com.ynov.banqueEL.dao.AccountManager;
import com.ynov.banqueEL.dao.ClientManager;
import com.ynov.banqueEL.model.Account;
import com.ynov.banqueEL.model.Client;

import java.util.List;

public class TestJDBC {

    public static void main(String[] args) {
//        Client result = ClientManager.getClientByID(1);

        List<Account> results = AccountManager.getAccountsByClientID(1);

        System.out.println(results.toString());
    }
}
