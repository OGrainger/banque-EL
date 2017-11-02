package com.ynov.online.bank.servlet;

import com.ynov.online.bank.helper.ServletHelper;
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
@WebServlet(name = "SERVLET_CLIENT", value = "/client")
public class ClientServlet extends HttpServlet {

    private static ServletHelper helper = new ServletHelper();
    private static ClientManager clientManager = new ClientManager();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = clientManager.selectWithId(request.getSession().getAttribute(helper.CONST_CLIENT).toString());
        String verification = request.getParameter("verification");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String infoStringVerification = ((password != null && password.equals("")) ? client.getPassword() : password) + ((firstName != null && firstName.equals("")) ? client.getFirstName() : firstName) + ((lastName != null && lastName.equals("")) ? client.getLastName() : lastName);
        String infoStringVerification_OLD = client.getPassword() + client.getFirstName() + client.getLastName();

        float clientFullBalance = 0;
        for (Account a : client.getAccounts()) {
            clientFullBalance += a.getBalance();
        }
        request.setAttribute("isConnected", true);
        request.setAttribute("page", helper.CONST_CLIENT);
        request.setAttribute("clientFullBalance", clientFullBalance);
        request.setAttribute("keepModalOpen", true);

        if (verification.equals(client.getPassword())) {
            if (password != null && !password.equals("") && !(password.equals(client.getPassword()))) {
                client.setPassword(password);
            }
            if ((firstName != null) && !firstName.equals("") && !(firstName.equals(client.getFirstName()))) {
                client.setFirstName(firstName);
            }
            if ((lastName != null) && !lastName.equals("") && !(lastName.equals(client.getLastName()))) {
                client.setLastName(lastName);
            }
            Client updatedClient = clientManager.update(client);
            updatedClient.setAccounts(client.getAccounts());
            request.setAttribute(helper.CONST_CLIENT, client);

            if (updatedClient == null) {
                request.setAttribute("updateClientInternalError", true);

            } else if (infoStringVerification.equals(infoStringVerification_OLD)) {
                request.setAttribute("updateClientNoDifferenceError", true);
                request.setAttribute(helper.CONST_CLIENT, client);

            } else {
                request.setAttribute("keepModalOpen", false);
                request.setAttribute(helper.CONST_CLIENT, updatedClient);
            }
        } else {
            request.setAttribute("updateClientPasswordError", true);
            request.setAttribute(helper.CONST_CLIENT, client);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(helper.URI_INDEX);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Client client = clientManager.selectWithId(request.getSession().getAttribute(helper.CONST_CLIENT).toString());
        float clientFullBalance = 0;
        for (Account a : client.getAccounts()) {
            clientFullBalance += a.getBalance();
        }
        request.setAttribute("isConnected", true);
        request.setAttribute("page", helper.CONST_CLIENT);
        request.setAttribute("clientFullBalance", clientFullBalance);

        request.setAttribute(helper.CONST_CLIENT, client);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(helper.URI_INDEX);
        dispatcher.forward(request, response);

    }
}
