package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "shop")
@SecondaryTable(
        name = "shop_address",                                      // nazwa tabeli pomocniczej
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "shop_id")
)
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Column(table = "shop_address")                                 // kolumny z atrybutem table trafiają do tabeli pomocniczej
    String city;
    @Column(table = "shop_address")
    String street;

    public Shop() {
    }

    public Shop(String name, String city, String street) {
        this.name = name;
        this.city = city;
        this.street = street;
    }
}
