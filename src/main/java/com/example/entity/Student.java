package com.example.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_school",                                                // name - nazwa tabeli pośredniczącej
            joinColumns = @JoinColumn(name = "student_id"),                         // joinColumns - nazwa kolumny z kluczem encji Student
            inverseJoinColumns = @JoinColumn(name = "school_id")                    // inverseJoinColumns - nazwa kolumny z kluczem encji School
    )
    Set<School> schools = new HashSet<>();                                          // pole wg. którego będzie mapowana relacja w bazie danych

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public void addSchool(School school) {
        schools.add(school);
    }

    public String getName() {
        return name;
    }
}
