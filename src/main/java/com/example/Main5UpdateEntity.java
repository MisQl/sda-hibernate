package com.example;

import com.example.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main5UpdateEntity {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog = session.find(Dog.class, 1L);
        dog.setAge(20);

        transaction.commit();
        session.close();
    }

    /*
        1.  Ostateczny stan naszego psa w bazie danych
            id      1
            age     20
            name    Ares
            race    Terier
    */
}
