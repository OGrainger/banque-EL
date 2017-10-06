package com.ynov.banqueEL.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    private int clientID;
    private String firstName;
    private String lastName;
    private String password;
    private String login;

    public String toString() {
        return firstName + ' ' + lastName + ' ' + clientID + ' ' + login;
    }
}
