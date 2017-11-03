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
import java.util.Random;

// Created on 13/10/2017

@WebServlet(value = "/login", name = "SERVLET_LOGIN")
public class LoginServlet extends HttpServlet {

    private static ServletHelper helper = new ServletHelper();
    private static ClientManager clientManager = new ClientManager();
    private static AccountManager accountManager = new AccountManager();
    private Random random = new Random();

    private final String alphabet = "0123456789ABCDEF ";
    private final int N = alphabet.length();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Boolean hasErrors = false;
        if (request.getParameter("action").equals("login")) {
            Client c = clientManager.login(email, password);
            if (c != null) {
                request.getSession().setAttribute("client", c.getResourceId());
                response.sendRedirect(helper.URI_CLIENT);
            } else {
                hasErrors = true;
                request.setAttribute("wrongCredentialsError", true);
            }
        } else if (request.getParameter("action").equals("register")) {
            if (clientManager.isLoginAvailable(email)) {
                Client c = new Client();
                Account a = new Account();

                c.setLogin(email);
                c.setPassword(password);
                clientManager.create(c);

                StringBuilder iban = new StringBuilder();
                a.setBalance(100);
                for (int i = 0; i < 18; i++) {
                    iban.append(alphabet.charAt(random.nextInt(N)));
                }
                a.setIban(iban.toString());
                a.setClient(c);
                a.setDescription("Compte courant");
                accountManager.create(a);

                request.getSession().setAttribute("client", c.getResourceId());
                response.sendRedirect(helper.URI_CLIENT);
            } else {
                hasErrors = true;
                request.setAttribute("loginAlreadyExistsError", true);
            }
        }

        if (hasErrors) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(helper.URI_INDEX);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute(helper.CONST_CLIENT) != null) {
            response.sendRedirect(helper.URI_CLIENT);
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(helper.URI_INDEX);
            dispatcher.forward(request, response);
        }
    }
}
