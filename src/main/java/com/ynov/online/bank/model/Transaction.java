package com.ynov.online.bank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction extends AbstractRestResource {

    private double amount;

    @CreationTimestamp
    private Timestamp date;

    private String description;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private Account recipientAccount;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private Account donorAccount;

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", recipientAccount=" + recipientAccount +
                ", donorAccount=" + donorAccount +
                '}';
    }
}
