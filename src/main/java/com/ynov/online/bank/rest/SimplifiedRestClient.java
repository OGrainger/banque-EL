package com.ynov.online.bank.rest;

import com.ynov.online.bank.controller.ClientCtrl;
import com.ynov.online.bank.model.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SimplifiedRestClient {

    private static Logger logger = LogManager.getLogger(SimplifiedRestClient.class);
    private static ClientCtrl clientCtrl = new ClientCtrl();

    @GET
    public List getAllClients() {
        return clientCtrl.getAll();
    }

    @POST
    public Client createClient(Client client) {
        return clientCtrl.create(client);
    }

    @POST
    @Path("/{id})")
    public Client updateClientById(@PathParam("id") int id, Client client) {

        Client clientToEdit = new Client();
        clientToEdit.setFirstName(client.getFirstName());
        clientToEdit.setLastName(client.getLastName());
        clientToEdit.setLogin(client.getLogin());
        clientToEdit.setPassword(client.getPassword());

        return clientToEdit;
    }

    @GET
    @Path("/{id}")
    public Response getClientById(@PathParam("id") int id) {

        logger.info("REQ FOR CLIENT ID : " + id);

        Client client = clientCtrl.getWithId(id);
        logger.info("GET " + client.getFirstName() + " " + client.getLastName());

        return Response.ok().type(MediaType.APPLICATION_JSON).entity(client).build();
    }
}
