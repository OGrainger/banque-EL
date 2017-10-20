package com.ynov.online.bank.rest;

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

    private static ObjectMapper mapper = new ObjectMapper();

    private static ClientCtrl clientCtrl = new ClientCtrl();


    public void init() throws ServletException {
        // Do required initialization
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] uri = request.getRequestURI().split("/");
        int clientId = Integer.parseInt(uri[uri.length - 1]);
        logger.info("PUT FOR CLIENT ID : " + clientId);

        Client clientToEdit = new Client();
        clientToEdit.setResourceId(Integer.parseInt(request.getParameter("resourceId")));
        clientToEdit.setFirstName(request.getParameter("firstname"));
        clientToEdit.setLastName(request.getParameter("lastname"));
        clientToEdit.setPassword(request.getParameter("password"));

        try {
            clientCtrl.update(clientToEdit);
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.print("Error on update");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] uri = request.getRequestURI().split("/");
        int clientId = Integer.parseInt(uri[uri.length - 1]);
        logger.info("REQ FOR CLIENT ID : " + clientId);

        Client client = clientCtrl.getWithId(clientId);

        logger.info("GET " + client.getFirstName() + " " + client.getLastName());

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(mapper.writeValueAsString(client));
    }
}
