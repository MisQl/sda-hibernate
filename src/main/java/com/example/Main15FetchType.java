package com.example;

import com.example.entity.School;
import com.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Set;

public class Main15FetchType {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        School school = session.find(School.class, 1L);
        Set<Student> students = school.getStudents();

        students.stream()
                .map(Student::getName)                                          // w przypadku FetchType.LAZY w tym momencie jest wykonywane dodatkowe zapytanie o popranie informacji o kolekcji
                .forEach(System.out::println);                                  // ustawione FetchType.EAGER powoduje, że te informacje zostaną pobrane 1 zapytaniem podczas session.find()

        transaction.commit();
        session.close();
    }
}
