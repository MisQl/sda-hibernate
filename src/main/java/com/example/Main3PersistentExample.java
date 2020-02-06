package com.example;

import com.example.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main3PersistentExample {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dog = new Dog("Azor", 10, "Husky");

        System.out.println(dog.getId());                // null - stworzony pies nie ma jeszcze id
        session.persist(dog);                           // pies zostanie zapisany w bazie danych i dodany do kontekstu persystencji
        System.out.println(dog.getId());                // 6 - zwróci wartość id w bazie
        dog.setAge(11);                                 // ta zmiana zostanie wysłana przez Hibernate do bazy danych

        session.evict(dog);                             // odłaczenie psa od kontekstu persystencji
        dog.setRace("Chihuahua");                       // ta zmiana nie będzie wysłana przez Hibernate do bazy danych

        transaction.commit();
        session.close();
    }

    /*
        1.  Ostateczny stan naszego psa w bazie danych
            id      6
            age     10
            name    Azor
            race    Husky
    */
}
