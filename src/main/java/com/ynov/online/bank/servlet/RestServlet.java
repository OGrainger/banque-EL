package com.ynov.online.bank.servlet;

import com.ynov.online.bank.servlet.restCtrl.RestClientCtrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/rest/*", name = "Rest_Client")
public class RestServlet extends HttpServlet {

    private static RestClientCtrl restClientCtrl = new RestClientCtrl();
    private static String CONST_CLIENT = "client";
    private static String CONST_ACCOUNT = "account";
    private static String CONST_TRANSACTION = "transaction";
    private static String CONST_TRANSACTION_AS_DONOR = "transaction-as-donor";
    private static String CONST_TRANSACTION_AS_RECIPIENT = "transaction-as-recipient";

    public void init() throws ServletException {
        // Do required initialization
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uri = request.getRequestURI().split("/");
        String primaryKey = uri[uri.length-2];
        String primaryValue = uri[uri.length-1];
        String result = null;

        if (primaryKey.equals(CONST_CLIENT)) {
            result = restClientCtrl.getClientWithId(primaryValue);
        } else if (primaryKey.equals(CONST_ACCOUNT)) {
            //
        } else if (primaryKey.equals(CONST_TRANSACTION_AS_DONOR)) {
            //
        } else if (primaryKey.equals(CONST_TRANSACTION_AS_RECIPIENT)) {
            //
        }

        response.setContentType(MediaType.APPLICATION_JSON);
        PrintWriter out = response.getWriter();
        out.print(result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uri = request.getRequestURI().split("/");
        String primaryKey = uri[uri.length-1];
        String result = null;

        if (primaryKey.equals(CONST_CLIENT)) {
            result = restClientCtrl.createClient(request);
        } else if (primaryKey.equals(CONST_ACCOUNT)) {
            //
        } else if (primaryKey.equals(CONST_TRANSACTION)) {
            //
        }

        response.setContentType(MediaType.APPLICATION_JSON);
        PrintWriter out = response.getWriter();
        out.print(result);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uri = request.getRequestURI().split("/");
        String primaryKey = uri[uri.length-2];
        String primaryValue = uri[uri.length-1];
        String result = null;

        if (primaryKey.equals(CONST_CLIENT)) {
            result = restClientCtrl.updateClient(primaryValue, request);
        } else if (primaryKey.equals(CONST_ACCOUNT)) {
            //
        }

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(result);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uri = request.getRequestURI().split("/");
        String primaryKey = uri[uri.length-2];
        String primaryValue = uri[uri.length-1];
        String result = null;

        if (primaryKey.equals(CONST_CLIENT)) {
            //
        } else if (primaryKey.equals(CONST_ACCOUNT)) {
            //
        }

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(result);
    }
}
