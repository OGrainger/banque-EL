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
        Client client = (Client) request.getSession().getAttribute(helper.CONST_CLIENT);
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        if ((password != null) && !(password.equals(client.getPassword()))) {
            client.setPassword(password);
        }
        if ((firstName != null) && !(firstName.equals(client.getFirstName()))) {
            client.setFirstName(firstName);
        }
        if ((lastName != null) && !(lastName.equals(client.getLastName()))) {
            client.setLastName(lastName);
        }
        Client updatedClient = clientManager.update(client);
        float clientFullBalance = 0;
        for (Account a : client.getAccounts()) {
            clientFullBalance += a.getBalance();
        }
        request.setAttribute("isConnected", true);
        request.setAttribute("page", helper.CONST_CLIENT);
        request.setAttribute("clientFullBalance", clientFullBalance);

        if (updatedClient == null) {
            request.setAttribute("updateClientError", true);
            request.setAttribute(helper.CONST_CLIENT, client);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute(helper.CONST_CLIENT, updatedClient);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
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
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }
}
