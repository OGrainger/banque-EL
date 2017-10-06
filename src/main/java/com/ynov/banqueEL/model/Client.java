package com.ynov.banqueEL.model;

public class Client {

    private String firstName;
    private String lastName;
    private int clientID;
    private String password;
    private String login;

    public String toString() {
        return firstName + ' ' + lastName + ' ' + clientID + ' ' + login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String n) {
        firstName = n;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String n) {
        lastName = n;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int n) {
        clientID = n;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String n) {
        password = n;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String n) {
        login = n;
    }
}
