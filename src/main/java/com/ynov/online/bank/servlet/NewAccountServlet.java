package com.ynov.online.bank.servlet;

import com.ynov.online.bank.helper.ServletHelper;
import com.ynov.online.bank.manager.AccountManager;
import com.ynov.online.bank.manager.ClientManager;
import com.ynov.online.bank.model.Account;
import com.ynov.online.bank.model.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Created on 27/10/2017.
@WebServlet(name = "SERVLET_NEW_ACCOUNT", value = "/new-account")
public class NewAccountServlet extends HttpServlet {

    private static ServletHelper helper = new ServletHelper();
    private static ClientManager clientManager = new ClientManager();
    private static AccountManager accountManager = new AccountManager();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Client client = clientManager.selectWithId(request.getSession().getAttribute(helper.CONST_CLIENT).toString());
        String description = request.getParameter("description");

        Account newAccount = new Account();
        newAccount.setDescription(description);
        newAccount.setBalance(0);
        newAccount.setIban("n/a");
        newAccount.setClient(client);
        accountManager.create(newAccount);

        response.sendRedirect(helper.URI_CLIENT);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Client client = clientManager.selectWithId(request.getSession().getAttribute(helper.CONST_CLIENT).toString());

        request.setAttribute("isConnected", true);
        request.setAttribute("page", helper.CONST_NEW_ACCOUNT);
        request.setAttribute(helper.CONST_CLIENT, client);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(helper.URI_INDEX);
        dispatcher.forward(request, response);

    }
}
