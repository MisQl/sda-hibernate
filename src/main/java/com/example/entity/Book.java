package com.example.entity;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToOne
    Client client;                                                      // pole client przechowuje informację o relacji, dlatego jeśli będzie puste
                                                                        // relacja nie będzie występowała

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
