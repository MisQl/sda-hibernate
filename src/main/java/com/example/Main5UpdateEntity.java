package com.example;

import com.example.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main5UpdateEntity {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dogOne = new Dog();
        dogOne.setId(1L);
        dogOne.setName("Ares");
        dogOne.setRace("Terier");
        dogOne.setAge(20);
        session.update(dogOne);                         // UPDATE wysyła stan całej encji dog
                                                        // jeśli jakieś pole ma wartość null, to również zotanie zaktualizowane

        Dog dogTwo = session.find(Dog.class, 2L);   // pobiera encje o id=2 -> name=Sonia, race=Buldog, age=10
        if (dogTwo != null) {
            dogTwo.setAge(25);
        }

        transaction.commit();                           // UPDATE dog SET name=Ares, race=Terier, age=20 WHERE dog.id=1;
                                                        // jeśli dog o id 1 nie istnieje to rzuci OptimisticLockException
                                                        // UPDATE dog SET name=Sonia, race=Bulgod, age=25 WHERE dog.id=2;
        session.close();
    }

    /*
        1.  Ostateczny stan w bazie danych
            id      1
            age     20
            name    Ares
            race    Terier

            id      2
            age     25
            name    Sonia
            race    Bulgod
    */
}
