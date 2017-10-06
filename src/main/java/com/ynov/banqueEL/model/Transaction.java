package com.ynov.banqueEL.model;

import java.sql.Timestamp;

public class Transaction {

    private int transactionID;
    private int debtor;
    private int creditor;
    private double amount;
    private Timestamp date;
    private String description;

    public String toString() {
        return transactionID + ' ' + debtor + ' ' + creditor + ' ' + amount + ' ' + date.toString() + ' ' + description;
    }

}
