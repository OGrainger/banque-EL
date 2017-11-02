package com.ynov.online.bank.helper;// Created on 27/10/2017.

import com.ynov.online.bank.controller.RestAccountCtrl;
import com.ynov.online.bank.controller.RestClientCtrl;
import com.ynov.online.bank.controller.RestTransactionCtrl;

public class ServletHelper {

    public RestClientCtrl restClientCtrl = new RestClientCtrl();
    public RestAccountCtrl restAccountCtrl = new RestAccountCtrl();
    public RestTransactionCtrl restTransactionCtrl = new RestTransactionCtrl();
    public String CONST_CLIENT = "client";
    public String CONST_ACCOUNT = "account";
    public String CONST_TRANSACTION = "transaction";
    public String CONST_TRANSACTION_AS_DONOR = "transactions-as-donor";
    public String CONST_TRANSACTION_AS_RECIPIENT = "transactions-as-recipient";

    public String URI_CLIENT = "/client";
    public String URI_LOGIN = "/login";
    public String URI_INDEX = "/index.jsp";

    public String CONTENT_TYPE = "Content-Type";
    public String CONTENT_APPLICATION_JSON = "application/json";

}
