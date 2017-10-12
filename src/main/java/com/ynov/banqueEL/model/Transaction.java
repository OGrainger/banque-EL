package com.ynov.banqueEL.model;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionID;

    @NotNull
    private double amount;

    @CreationTimestamp
    private Timestamp date;

    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name="debtor")
    private Account debtorAccount;

    @NotNull
    @ManyToOne
    @JoinColumn(name="creditor")
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
        return transactionID + " " + amount + " " + date.toString() + " " + description;
    }

}
