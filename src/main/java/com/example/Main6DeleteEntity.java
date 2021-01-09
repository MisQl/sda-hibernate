package com.example;

import com.example.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main6DeleteEntity {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog = session.find(Dog.class, 2L);
        System.out.println(dog);

        session.delete(dog);                            // jeśli dog o id 2 nie istnieje to rzuci IllegalArgumentException bo dog=null

        Dog otherDog = new Dog();
        otherDog.setId(3L);

        session.delete(otherDog);

        transaction.commit();                           // jeśli dog o id 3 nie istnieje to rzuci OptimisticLockException
        session.close();
    }
}
