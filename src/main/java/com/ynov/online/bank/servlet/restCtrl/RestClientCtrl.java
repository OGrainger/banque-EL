package com.ynov.online.bank.servlet.restCtrl;// Created on 26/10/2017.

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ynov.online.bank.manager.ClientManager;
import com.ynov.online.bank.model.Client;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RestClientCtrl {

    private static ClientManager clientManager = new ClientManager();
    private static ObjectMapper mapper = new ObjectMapper();

    public String getClientWithId(String id) {
        try {
            return mapper.writeValueAsString(clientManager.selectWithId(Integer.parseInt(id)));
        } catch(Exception e) {
            return null;
        }
    }

    public String createClient(HttpServletRequest request) throws IOException {
        Client client = mapper.readValue(request.getInputStream(), Client.class);
        return mapper.writeValueAsString(clientManager.create(client));
    }

    public String updateClient(String id, HttpServletRequest request) {
        try {
            Client client = clientManager.selectWithId(Integer.parseInt(id));
            Client updatedClient = mapper.readValue(request.getInputStream(), Client.class);
            updatedClient.setResourceId(client.getResourceId());
            return mapper.writeValueAsString(clientManager.update(updatedClient));
        } catch (Exception e) {

        }
        return null;
    }
}