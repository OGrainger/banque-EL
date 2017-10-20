package com.ynov.online.bank.servlet;

import com.ynov.online.bank.controller.ClientCtrl;
import com.ynov.online.bank.model.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Created on 13/10/2017

@WebServlet(value = "/test", name = "TEST")
public class ServletTest extends HttpServlet {

    private static Logger logger = LogManager.getLogger(ServletTest.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClientCtrl clientCtrl = new ClientCtrl();
        Client client = clientCtrl.getWithId(27);

        request.setAttribute("stringTest", "test OK");
        request.setAttribute("client", client);
        logger.info("DEBUG : GET " + client.getFirstName() + " " + client.getLastName());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/index.jsp");

        try {
            dispatcher.forward(request, response);

        } catch (ServletException e) {
            response.setContentType("text/html");
            //TODO : write error pages
            response.getWriter().println("<h1>Oops, something went wrong</h1>");
        }
    }
}
