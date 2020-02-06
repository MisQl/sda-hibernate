package com.example.entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("apple")
public class Apple extends Fruit {

    String color;

    public Apple() {
    }

    public Apple(String description, String color) {
        this.description = description;
        this.color = color;
    }
}
