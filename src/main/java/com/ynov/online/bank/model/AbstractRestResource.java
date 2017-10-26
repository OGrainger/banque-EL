package com.ynov.online.bank.model;


import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
abstract class AbstractRestResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int resourceId;
}
