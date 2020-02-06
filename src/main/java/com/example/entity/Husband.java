package com.example.entity;

import javax.persistence.*;

@Entity
public class Husband {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
                                                                            // orphanRemoval ustawione na true informuje, że z bazy zostaną usunięte encje Wife, które straciły relację z Husband
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)              // CascadeType.ALL powoduje, że operacje wykonywane na encji Husband są propagowane na encję Wife np. session.persist
    @JoinColumn(name = "my_wife_id")                                        // @JoinColumn - nadpisujemy domyślną nazwę kolumny klucza obcego, który zarządza relacją
    Wife wife;

    public Husband() {
    }

    public Husband(String name) {
        this.name = name;
    }

    public Husband(String name, Wife wife) {
        this.name = name;
        this.wife = wife;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
