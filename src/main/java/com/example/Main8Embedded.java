package com.example;

import com.example.entity.Address;
import com.example.entity.Form;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main8Embedded {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Form form = new Form();
        session.persist(form);

        form.setDescription("Lore ipsum");

        Address address = new Address("Aleja Grunwaldzka", "Gdańsk");
        form.setAddress(address);

        address.setStreet("Fryderyka Chopina");

        transaction.commit();
        session.close();
    }

    /*
        1.  W klasie Form znajduje się opis adnotacji

        2.  Ostateczny stan naszego formularza w bazie danych
            id              1
            city            Gdańsk
            street          Fryderyka Chopina
            description     Lore ipsum
    */
}
