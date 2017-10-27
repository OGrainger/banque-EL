package com.ynov.online.bank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true, exclude = {"recipientTransactions","donorTransactions"})
@Getter
@Setter
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
    @OneToMany(mappedBy = "recipientAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> recipientTransactions;

    @JsonIgnore
    @OneToMany(mappedBy = "donorAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> donorTransactions;

    @Override
    public String toString() {
        return "Account{" +
                "description='" + description + '\'' +
                ", money=" + money +
                ", iban='" + iban + '\'' +
                ", client=" + client +
                '}';
    }
}
