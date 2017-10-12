package com.ynov.banqueEL.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    private int clientID;
    private String description;
    private double money;
    @ManyToOne
    @JoinColumn(name="ClientID")
    private Client client;
    @OneToMany(mappedBy = "debtorAccount", cascade = CascadeType.ALL)
    private List<Transaction> debtorTransactions;
    @OneToMany(mappedBy = "creditorAccount", cascade = CascadeType.ALL)
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
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

    public String toString() {
        return number + ' ' + clientID + ' ' + description + ' ' + money;
    }
}
