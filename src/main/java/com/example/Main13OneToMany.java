package com.example;

import com.example.entity.Book;
import com.example.entity.Client;
import com.example.entity.Husband;
import com.example.entity.Wife;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main13OneToMany {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Client client = new Client("Andrzej");
        client.addBook(new Book("Ogniem i mieczem"));
        client.addBook(new Book("Alicja w krainie czarów"));
        client.addBook(new Book("Harry Potter"));
        client.addBook(new Book("Władca pierścieni"));

        session.persist(client);

        transaction.commit();
        session.close();
    }

    /*
        1.  W klasach Client i Book znajduje się opis użytych adnotacji
    */
}
