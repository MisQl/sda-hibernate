package com.example.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("orange")
public class Orange extends Fruit {

    String size;

    public Orange() {
    }

    public Orange(String description, String size) {
        this.description = description;
        this.size = size;
    }
}
