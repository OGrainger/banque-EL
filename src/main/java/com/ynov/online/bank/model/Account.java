package com.ynov.online.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account extends AbstractRestResource {

    private String description;

    private double money;

    private String iban;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "client_id")
    private Client client;

    @JsonIgnore
    @OneToMany(mappedBy = "debtorAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> debtorTransactions;

    @JsonIgnore
    @OneToMany(mappedBy = "creditorAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> creditorTransactions;


    //GETTER SETTER

    public List<Transaction> getDebtorTransactions() {
        return debtorTransactions;
    }

    public void setDebtorTransactions(List<Transaction> debtorTransactions) {
        this.debtorTransactions = debtorTransactions;
    }

    public List<Transaction> getCreditorTransactions() {
        return creditorTransactions;
    }

    public void setCreditorTransactions(List<Transaction> creditorTransactions) {
        this.creditorTransactions = creditorTransactions;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }


    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }


    public String toString() {
        return description + " " + money;
    }
}
