package com.example;

import com.example.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main4FindEntity {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Dog dogOne = session.find(Dog.class, 1L);           // jak nie znajdzie krotki o podanym id to zwróci null, ładuje obiekt zachłannie (EAGER)
        if (dogOne != null) {
            System.out.println(dogOne.getId());
            System.out.println(dogOne.getName());
        }

        Dog dogTwo = session.get(Dog.class, 2L);            // jak nie znajdzie krotki o podanym id to zwróci null, ładuje obiekt zachłannie (EAGER)
        if (dogTwo != null) {
            System.out.println(dogTwo.getId());
            System.out.println(dogTwo.getName());
        }

        Dog dogThree = session.load(Dog.class, 100L);       // ładuje obiekt leniwie (LAZY), dopiero podczas odwołania do pól innych niż id jest on pobierany z bazy
        if (dogThree != null) {                                 // dogThree jest proxy i nigdy nie będzie null
            System.out.println(dogThree.getId());               // obiekt proxy zwróci 100
            System.out.println(dogThree.getAge());              // zostanie wysłane zapytanie do bazy danych i jeśli nie istnieje to rzuci wyjątkiem ObjectNotFoundException
        }

        transaction.commit();
        session.close();
    }
}
