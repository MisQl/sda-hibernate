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

        Dog dog = new Dog();
        dog.setId(1L);
        dog.setName("Ares");
        dog.setRace("Terier");
        dog.setAge(20);
        session.update(dog);                        // UPDATE wysyła stan całej encji dog
                                                    // jeśli jakieś pole ma wartość null, to również zotanie zaktualizowane

        transaction.commit();                       // UPDATE dog SET name=Ares, race=Terier, age=20 WHERE dog.id = 1;
                                                    // jeśli dog o id 1 nie istnieje to rzuci OptimisticLockException
        session.close();
    }

    /*
        1.  Ostateczny stan dog w bazie danych
            id      1
            age     20
            name    Ares
            race    Terier
    */
}
