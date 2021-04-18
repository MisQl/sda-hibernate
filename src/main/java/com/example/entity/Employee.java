package com.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_table")                                 // definiujemy nazwę tabeli, inaczej nazwa jest określana na podstawie nazwy klasy
public class Employee {

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
    @Basic(fetch = FetchType.LAZY)                              // przykłądowe użycie adnotacji @Basic pozwala na leniwe załadowanie danych:
    String description;                                         // podczas ładowania wszystkich innych pól encji z bazy danychto to pole nie jest wypełnione
                                                                // dopiero podczas bezpośredniego odwołania się do pola przez np. getDescription() dane są pobierane do encji z bazy danych

    /*
        Żeby adnotacja @Basic(fetch = FetchType.LAZY) działała poprawnie trzeba dodać poniższy plugin do pom.xml
        https://docs.jboss.org/hibernate/orm/5.4/userguide/html_single/Hibernate_User_Guide.html#BytecodeEnhancement-enhancement-maven
        po dodaniu pluginu trzeba skompilować kod (mvn compile)
    */

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
