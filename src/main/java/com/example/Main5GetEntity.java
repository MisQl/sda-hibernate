package com.example;

import com.example.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main5GetEntity {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dogOne = session.find(Dog.class, 1L);       // jak nie znajdzie krotki o podanym id to zwróci null
        Dog dogThree = session.get(Dog.class, 2L);      // jak nie znajdzie krotki o podanym id to zwróci null
        Dog dogTwo = session.load(Dog.class, 100L);     // ładuje obiekt leniwie, dopiero podczas odwołania do pól innych niż id jest on pobierany z bazy

        if (dogTwo != null) {                           // dogTwo jest proxy i nigdy nie będzie null
            System.out.println(dogTwo.getId());         // obiekt proxy zwróci 100
            System.out.println(dogTwo.getAge());        // zostanie wysłane zapytanie do bazy danych i jeśli nie istnieje to rzuci wyjątkiem ObjectNotFoundException
        }

        transaction.commit();
        session.close();
    }
}
