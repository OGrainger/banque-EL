package com.ynov.online.bank.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Created on 13/10/2017
public class ServletName extends HttpServlet {

    private static Logger logger = LogManager.getLogger(ServletName.class);

    private static String m = "Hello World";

    public void init() throws ServletException {
        // Do required initialization
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        logger.info("GET : Servlet response OK");
        out.println("<h1>" + m + "</h1>");
    }
}
