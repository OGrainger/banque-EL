package com.ynov.online.bank.servlet;

import com.ynov.online.bank.servlet.restCtrl.RestAccountCtrl;
import com.ynov.online.bank.servlet.restCtrl.RestClientCtrl;
import com.ynov.online.bank.servlet.restCtrl.RestTransactionCtrl;

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
    private static RestAccountCtrl restAccountCtrl = new RestAccountCtrl();
    private static RestTransactionCtrl restTransactionCtrl = new RestTransactionCtrl();
    private static String CONST_CLIENT = "client";
    private static String CONST_ACCOUNT = "account";
    private static String CONST_TRANSACTION = "transaction";
    private static String CONST_TRANSACTION_AS_DONOR = "transactions-as-donor";
    private static String CONST_TRANSACTION_AS_RECIPIENT = "transactions-as-recipient";

    public void init() throws ServletException {
        // Do required initialization
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] uri = request.getRequestURI().split("/");
        String primaryKey = uri[uri.length - 2];
        String primaryValue = uri[uri.length - 1];
        String result = null;

        response = authorize(request, response);

        if (primaryKey.equals(CONST_CLIENT)) {
            result = restClientCtrl.getClientWithId(primaryValue);

        } else if (primaryKey.equals(CONST_ACCOUNT)) {
            result = restAccountCtrl.getAccountWithId(primaryValue);
        } else if (primaryKey.equals(CONST_TRANSACTION_AS_DONOR)) {
            result = restTransactionCtrl.getTransactionsFromDonorAccount(primaryValue);
        } else if (primaryKey.equals(CONST_TRANSACTION_AS_RECIPIENT)) {
            result = restTransactionCtrl.getTransactionsFromRecipientAccount(primaryValue);
        }

        response.setContentType(MediaType.APPLICATION_JSON);
        PrintWriter out = response.getWriter();
        out.print(result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uri = request.getRequestURI().split("/");
        String primaryKey = uri[uri.length - 1];
        String result = null;

        if (primaryKey.equals(CONST_CLIENT)) {
            result = restClientCtrl.createClient(request);
        } else if (primaryKey.equals(CONST_ACCOUNT)) {
            result = restAccountCtrl.createAccount(request);
        } else if (primaryKey.equals(CONST_TRANSACTION)) {
            result = restTransactionCtrl.createTransaction(request);
        }

        response.setContentType(MediaType.APPLICATION_JSON);
        PrintWriter out = response.getWriter();
        out.print(result);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] uri = request.getRequestURI().split("/");
        String primaryKey = uri[uri.length - 2];
        String primaryValue = uri[uri.length - 1];
        String result = null;

        if (primaryKey.equals(CONST_CLIENT)) {
            result = restClientCtrl.updateClient(primaryValue, request);
        }

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(result);
    }

    private HttpServletResponse authorize(HttpServletRequest req, HttpServletResponse res) {
        if (req.getSession().getAttribute("client") == null) {
            res.setStatus(403);
        }
        return res;
    }
}
