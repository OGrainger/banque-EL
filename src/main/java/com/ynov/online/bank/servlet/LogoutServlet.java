package com.ynov.online.bank.servlet;

import com.ynov.online.bank.helper.ServletHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Created on 13/10/2017

@WebServlet(value = "/logout", name = "SERVLET_LOGOUT")
public class LogoutServlet extends HttpServlet {

    private static ServletHelper helper = new ServletHelper();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().removeAttribute(helper.CONST_CLIENT);
        response.sendRedirect(helper.URI_LOGIN);
    }
}
