package com.ynov.banqueEL.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionID;
    private int debtor;
    private int creditor;
    private double amount;
    private Timestamp date;
    private String description;
    @ManyToOne
    @JoinColumn(name="number", insertable = false, updatable = false)
    private Account debtorAccount;
    @ManyToOne
    @JoinColumn(name="number", insertable = false, updatable = false)
    private Account creditorAccount;

    public Account getDebtorAccount() {
        return debtorAccount;
    }

    public void setDebtorAccount(Account debtorAccount) {
        this.debtorAccount = debtorAccount;
    }

    public Account getCreditorAccount() {
        return creditorAccount;
    }

    public void setCreditorAccount(Account creditorAccount) {
        this.creditorAccount = creditorAccount;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getDebtor() {
        return debtor;
    }

    public void setDebtor(int debtor) {
        this.debtor = debtor;
    }

    public int getCreditor() {
        return creditor;
    }

    public void setCreditor(int creditor) {
        this.creditor = creditor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return transactionID + ' ' + debtor + ' ' + creditor + ' ' + amount + ' ' + date.toString() + ' ' + description;
    }

}
