package com.ynov.online.bank.servlet;

import com.ynov.online.bank.helper.ServletHelper;
import com.ynov.online.bank.manager.ClientManager;
import com.ynov.online.bank.manager.TransactionManager;
import com.ynov.online.bank.model.Account;
import com.ynov.online.bank.model.Client;
import com.ynov.online.bank.model.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Created on 27/10/2017.
@WebServlet(name = "SERVLET_TRANSACTIONS", value = "/transactions")
public class TransactionsServlet extends HttpServlet {

    private static ServletHelper helper = new ServletHelper();
    private static ClientManager clientManager = new ClientManager();
    private static TransactionManager transactionManager = new TransactionManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Client client = clientManager.selectWithId(request.getSession().getAttribute(helper.CONST_CLIENT).toString());
        List<Transaction> transactionsAsDonor = new ArrayList<>();
        List<Transaction> transactionsAsRecipient = new ArrayList<>();
        for (Account account : client.getAccounts()) {
            transactionsAsDonor.addAll(transactionManager.getTransactionsFromDonorAccountId(String.valueOf(account.getResourceId())));
            transactionsAsRecipient.addAll(transactionManager.getTransactionsFromRecipientAccountId(String.valueOf(account.getResourceId())));
        }

        float clientFullBalance = 0;
        for (Account a : client.getAccounts()) {
            clientFullBalance += a.getBalance();
        }
        request.setAttribute("clientFullBalance", clientFullBalance);

        request.setAttribute("isConnected", true);
        request.setAttribute("page", helper.CONST_TRANSACTIONS);
        request.setAttribute(helper.CONST_CLIENT, client);
        request.setAttribute("transactionsAsDonor", transactionsAsDonor);
        request.setAttribute("transactionsAsRecipient", transactionsAsRecipient);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(helper.URI_INDEX);
        dispatcher.forward(request, response);

    }
}
