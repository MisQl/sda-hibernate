package com.example.entity;

import javax.persistence.*;

@Entity
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String description;                                     // adnotacja @Column nie jest wymagana - to pole zostanie bezproblemowo zmapowane

    @Embedded                                               // oznacza obiekt wbudowany - całość zostanie zawarta w jednej tabeli
    Address address;


    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
