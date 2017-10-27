package com.ynov.online.bank.servlet.restCtrl;// Created on 26/10/2017.

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ynov.online.bank.manager.AccountManager;
import com.ynov.online.bank.model.Account;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RestAccountCtrl {

    private static AccountManager accountManager = new AccountManager();
    private static ObjectMapper mapper = new ObjectMapper();

    public String getAccountWithId(String id) {
        try {
            return mapper.writeValueAsString(accountManager.selectWithId(id));
        } catch (Exception e) {
            return null;
        }
    }

    public String createAccount(HttpServletRequest request) throws IOException {
        Account account = mapper.readValue(request.getInputStream(), Account.class);
        return mapper.writeValueAsString(accountManager.create(account));
    }
}
