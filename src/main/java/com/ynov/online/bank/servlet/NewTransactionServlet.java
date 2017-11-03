package com.ynov.online.bank.servlet;

import com.ynov.online.bank.helper.ServletHelper;
import com.ynov.online.bank.manager.AccountManager;
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
import java.util.List;

// Created on 27/10/2017.
@WebServlet(name = "SERVLET_NEW_TRANSACTION", value = "/new-transaction")
public class NewTransactionServlet extends HttpServlet {

    private static ServletHelper helper = new ServletHelper();
    private static ClientManager clientManager = new ClientManager();
    private static AccountManager accountManager = new AccountManager();
    private static TransactionManager transactionManager = new TransactionManager();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Account donorAccount = accountManager.selectWithId(request.getParameter("donorAccountId"));
        Account recipientAccount = accountManager.selectWithId(request.getParameter("recipientAccountId"));
        Transaction transaction = new Transaction();
        
        transaction.setDonorAccount(donorAccount);
        transaction.setRecipientAccount(recipientAccount);
        transaction.setDescription(request.getParameter("description"));
        transaction.setAmount(Double.parseDouble(request.getParameter("amount")));

        transactionManager.create(transaction);

        donorAccount.setBalance(donorAccount.getBalance() - transaction.getAmount());
        recipientAccount.setBalance(recipientAccount.getBalance() + transaction.getAmount());

        accountManager.update(donorAccount);
        accountManager.update(recipientAccount);

        response.sendRedirect(helper.CONST_TRANSACTIONS);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Client client = clientManager.selectWithId(request.getSession().getAttribute(helper.CONST_CLIENT).toString());
        List<Account> allAccounts = accountManager.selectAll();

        request.setAttribute("isConnected", true);
        request.setAttribute("page", helper.CONST_NEW_TRANSACTION);
        request.setAttribute(helper.CONST_CLIENT, client);
        request.setAttribute("allAccounts", allAccounts);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(helper.URI_INDEX);
        dispatcher.forward(request, response);
    }
}
