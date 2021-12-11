package com.example;

import com.example.entity.Shop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main9SecondaryTable {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Shop shop = new Shop("Cukiernia Kowalsky", "Gdańsk", "Aleja Grunwaldzka");
        session.persist(shop);

        transaction.commit();
        session.close();
    }

    /*
        1.  W klasie Shop znajduje się opis adnotacji

        2.  Ostateczny stan tabeli shop
            id          1
            name        Cukiernia Kowalsky

        3.  Ostateczny stan tabeli shop_address
            city        Gdańsk
            street      Aleja Grunwaldzka
            shop_id     1
    */
}
