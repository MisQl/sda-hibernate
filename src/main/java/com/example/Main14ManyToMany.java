package com.example;

import com.example.entity.School;
import com.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main14ManyToMany {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        School schoolOne = new School("PG");
        School schoolTwo = new School("UG");

        Student studentOne = new Student("Jan");
        Student studentTwo = new Student("Alicja");
        Student studentThree = new Student("Mirek");

        schoolOne.addStudent(studentOne);
        schoolOne.addStudent(studentTwo);

        schoolTwo.addStudent(studentTwo);
        schoolTwo.addStudent(studentThree);

        session.persist(schoolOne);
        session.persist(schoolTwo);

        transaction.commit();
        session.close();
    }

    /*
        1.  W klasach School i Student znajduje się opis użytych adnotacji
    */
}
