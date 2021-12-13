package com.example;

import com.example.entity.Husband;
import com.example.entity.Wife;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main10OneToOne {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Husband husband = new Husband("Adam");
        session.persist(husband);

        Wife wife = new Wife("Ewa");
        session.persist(wife);

        wife.setHusband(husband);                       // Wife nie jest właścicelem relacji, dlatego samo przypisanie Husband do Wife jest niewystarczające
                                                        // relacja nie zostanie odwzorowana w bazie danych
                                                        // dlatego implementacja wife.setHusband(husband) wykonuje husband.setWife(this)



        session.persist(new Husband("Damian", new Wife("Sabrina")));
        session.persist(new Husband("Bertek", new Wife("Kinga")));
        session.persist(new Husband("Kacper", new Wife("Natalia")));
        session.persist(new Husband("Piotr", new Wife("Joanna")));
        session.persist(new Husband("Michał", new Wife("Katarzyna")));

        transaction.commit();
        session.close();
    }

    /*
        1.  W klasach Husband i Wife znajduje się opis użytych adnotacji
    */
}
