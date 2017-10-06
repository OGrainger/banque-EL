package com.ynov.banqueEL.model;

public class Account {

    private int number;
    private int clientID;
    private String description;
    private double money;

    public String toString() {
        return number + ' ' + clientID + ' ' + description + ' ' + money;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getClientID() {
        return this.clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMoney() {
        return this.money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
