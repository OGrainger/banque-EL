package com.ynov.online.bank.servlet;

import com.ynov.online.bank.helper.ServletHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/rest/*", name = "REST")
public class RestServlet extends HttpServlet {

    private static ServletHelper helper = new ServletHelper();

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

        if (primaryKey.equals(helper.CONST_CLIENT)) {
            result = helper.restClientCtrl.getClientWithId(primaryValue);
        } else if (primaryKey.equals(helper.CONST_ACCOUNT)) {
            result = helper.restAccountCtrl.getAccountWithId(primaryValue);
        } else if (primaryKey.equals(helper.CONST_TRANSACTION_AS_DONOR)) {
            result = helper.restTransactionCtrl.getTransactionsFromDonorAccount(primaryValue);
        } else if (primaryKey.equals(helper.CONST_TRANSACTION_AS_RECIPIENT)) {
            result = helper.restTransactionCtrl.getTransactionsFromRecipientAccount(primaryValue);
        } else if (primaryKey.equals(helper.CONST_TRANSACTION)) {
            result = helper.restTransactionCtrl.getTransactionWithId(primaryValue);
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

        if (primaryKey.equals(helper.CONST_CLIENT)) {
            result = helper.restClientCtrl.createClient(request);
        } else if (primaryKey.equals(helper.CONST_ACCOUNT)) {
            result = helper.restAccountCtrl.createAccount(request);
        } else if (primaryKey.equals(helper.CONST_TRANSACTION)) {
            result = helper.restTransactionCtrl.createTransaction(request);
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

        if (primaryKey.equals(helper.CONST_CLIENT)) {
            result = helper.restClientCtrl.updateClient(primaryValue, request);
        }

        response.setContentType(helper.CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.print(result);
    }

    private HttpServletResponse authorize(HttpServletRequest req, HttpServletResponse res) {
        if (req.getSession().getAttribute(helper.CONST_CLIENT) == null) {
            res.setStatus(403);
        }
        return res;
    }
}
