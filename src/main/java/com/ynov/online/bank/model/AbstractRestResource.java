package com.ynov.online.bank.model;


import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractRestResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int resourceId;


    // GETTER SETTER

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
