package com.example;

import com.example.entity.Apple;
import com.example.entity.Orange;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main16Inheritance {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(new Apple("Szampion", "red"));
        session.persist(new Apple("Papierówka", "yellow"));
        session.persist(new Orange("Olbrzymia", "big"));
        session.persist(new Orange("Zwyczajna", "medium"));

        transaction.commit();
        session.close();
    }
}
