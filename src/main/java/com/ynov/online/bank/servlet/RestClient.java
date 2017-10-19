package com.ynov.online.bank.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ynov.online.bank.controller.ClientCtrl;
import com.ynov.online.bank.model.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/client/*", name = "Rest_Client")
public class RestClient extends HttpServlet {

    private static Logger logger = LogManager.getLogger(RestClient.class);


    public void init() throws ServletException {
        // Do required initialization
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] uri = request.getRequestURI().split("/");
        int clientId = Integer.parseInt(uri[uri.length - 1]);
        logger.info("REQ FOR CLIENT ID : " + clientId);

        ClientCtrl clientCtrl = new ClientCtrl();
        Client client = clientCtrl.getWithId(clientId);

        logger.info("GET " + client.getFirstName() + " " + client.getLastName());

        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(mapper.writeValueAsString(client));
    }
}
