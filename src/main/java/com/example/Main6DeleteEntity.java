package com.example;

import com.example.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.OptimisticLockException;

public class Main6DeleteEntity {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Dog dog = new Dog();
            dog.setId(3L);
            session.delete(dog);
            transaction.commit();                           // jeśli dog o id 3 nie istnieje to rzuci OptimisticLockException
        } catch (OptimisticLockException e) {
            System.out.println("Krotka o podanym id nie istnieje w bazie");
        }

        session.close();
    }
}
