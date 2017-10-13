package com.ynov.online.bank.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "transactions")
public class Transaction extends AbstractRestResource {

    private double amount;

    @CreationTimestamp
    private Timestamp date;

    private String description;

    @ManyToOne
    @JoinColumn(name = "debtor_id")
    private Account debtorAccount;

    @ManyToOne
    @JoinColumn(name = "creditor_id")
    private Account creditorAccount;


    // GETTER SETTER

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
        return amount + " " + date.toString() + " " + description;
    }

}
