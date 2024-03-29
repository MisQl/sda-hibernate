package com.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_table")                                 // definiujemy nazwę tabeli, inaczej nazwa jest określana na podstawie nazwy klasy
public class Employee {                                         // ustawienie parametru @Entity(name="") również zdefiniuje nazwę tabeli, ale jeszcze
                                                                // zmieni nazwę encji - ma to wpływ na zapytania HQL w których nazwa encji jest wykorzystywana
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)                                   // wartość nie może być null, w przypadku próby zapisu encji z wartością tego pola null, rzuci wyjątkiem
    String name;

    @Column(name = "password")                                  // definiujemy nazwę kolumny, inaczej nazwa jest określana na podstawie nazwy pola
    String secret;

    @Column(length = 9, unique = true)                          // w przypadku łańcucha znaków określamy jego długość na 9 znaków
    String telephoneNumber;                                     // dodatkowo pole jest oznaczone jako unikalne, czyli wartość jaką przyjmuje nie może się powtórzyć w kolumnie

    @Transient                                                  // pole nie występuje w tabeli (baza danych) i nie podelga mapowaniu przez ORM
    long age;

    @Temporal(TemporalType.DATE)                                // w przypadku użycia klas do określania czasu z pakietu java.util np. java.util.Date
    Date birthDate;                                             // należy użyć adnotacji @Temporal żeby określić typ kolumny w bazie danych

    @Enumerated(value = EnumType.STRING)                        // przykłądowe użycie pozwala na zapisanie wartości enumów w bazie danych w postaci String'a
    Gender gender;                                              // bez tak użytej adnotacji enum byłby przechowywana jako Integer

    @Lob                                                        // adnotacja @Lob (Large object) informuje, że pole zawiera duże ilości danych - może być użyta do typu znakowego (np. String) lub binarnego (np. byte[])
    String description;

    public Employee() {
    }

    public Employee(String name, String secret, String telephoneNumber, long age, Date birthDate, Gender gender, String description) {
        this.name = name;
        this.secret = secret;
        this.telephoneNumber = telephoneNumber;
        this.age = age;
        this.birthDate = birthDate;
        this.gender = gender;
        this.description = description;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
