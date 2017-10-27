package com.ynov.online.bank.controller;// Created on 26/10/2017.

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ynov.online.bank.manager.TransactionManager;
import com.ynov.online.bank.model.Transaction;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RestTransactionCtrl {

    private static TransactionManager transactionManager = new TransactionManager();
    private static ObjectMapper mapper = new ObjectMapper();

    public String getTransactionWithId(String id) {
        try {
            return mapper.writeValueAsString(transactionManager.selectWithId(id));
        } catch (Exception e) {
            return null;
        }
    }

    public String createTransaction(HttpServletRequest request) throws IOException {
        Transaction transaction = mapper.readValue(request.getInputStream(), Transaction.class);
        return mapper.writeValueAsString(transactionManager.create(transaction));
    }

    public String getTransactionsFromRecipientAccount(String id) {
        try {
            return mapper.writeValueAsString(transactionManager.getTransactionsFromRecipientAccountId(id));
        } catch (Exception e) {
            return null;
        }
    }

    public String getTransactionsFromDonorAccount(String id) {
        try {
            return mapper.writeValueAsString(transactionManager.getTransactionsFromDonorAccountId(id));
        } catch (Exception e) {
            return null;
        }
    }
}
