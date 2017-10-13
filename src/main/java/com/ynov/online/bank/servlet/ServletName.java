package com.ynov.online.bank.servlet;

import com.ynov.online.bank.model.Account;
import com.ynov.online.bank.model.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Created on 13/10/2017
public class ServletName extends HttpServlet {

    private static Logger logger = LogManager.getLogger(ServletName.class);

    public void init() throws ServletException {
        // Do required initialization
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Client client = new Client();

        client.setFirstName("Toto");
        client.setLastName("Africa");
        client.setLogin("foo");

        List<Account> accounts = new ArrayList<>();
        Account a = new Account();
        a.setClient(client);
        a.setDescription("courant");
        a.setMoney(42);
        accounts.add(a);
        client.setAccounts(accounts);

        request.setAttribute("stringTest", "TEUB");
        request.setAttribute("client", client);

        logger.info("DEBUG : ", client.getFirstName());

        /*response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>" + "C'est un aveugle qui rentre dans un bar, puis une chaise, puis une table" + "</h1>");*/

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/client.jsp");
        dispatcher.forward(request, response);
    }
}
