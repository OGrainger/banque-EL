package com.ynov.online.bank.servlet;

import com.ynov.online.bank.manager.ClientManager;
import com.ynov.online.bank.model.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Created on 13/10/2017

@WebServlet(value = "/login", name = "SERVLET_LOGIN")
public class LoginServlet extends HttpServlet {

    private static ClientManager clientManager = new ClientManager();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Boolean hasErrors = false;
        if (request.getParameter("login") != null) {
            Client c = clientManager.login(email, password);
            if (c != null) {
                request.getSession().setAttribute("client", c.getResourceId());
                response.sendRedirect("/client/" + c.getResourceId());
            } else {
                hasErrors = true;
                request.setAttribute("wrongCredentialsError", true);
            }
        } else {
            if (clientManager.isLoginAvailable(email)) {
                Client c = new Client();
                c.setLogin(email);
                c.setPassword(password);
                clientManager.create(c);
                request.getSession().setAttribute("client", c.getResourceId());
                response.sendRedirect("/client/" + c.getResourceId());
            } else {
                hasErrors = true;
                request.setAttribute("loginAlreadyExistsError", true);
            }
        }
        if (hasErrors) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("client") != null) {
            response.sendRedirect("/client/" + request.getSession().getAttribute("client"));
        } else {
            request.setAttribute("!isConnected", false);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
