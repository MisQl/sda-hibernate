package com.example;

import com.example.entity.Husband;
import com.example.entity.Wife;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main12MergeCascade {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Husband husband = new Husband();
        husband.setId(3L);
        husband.setName("Janusz");

        Wife wife = new Wife();
        wife.setName("Aleksandra");
        husband.setWife(wife);

        session.merge(husband);                 // @OneToOne(cascade = CascadeType.ALL) ustawione w encji husband powoduje, że
                                                // zostanie stworzona w bazie nowa encja Wife, która będzie przypisana do Husband
                                                // @OneToOne(orphanRemoval = true) ustawione w encji husband powoduje, że
                                                // stara encja Wife, która straciła relację z Husband zostanie usunięta z bazy danych

        transaction.commit();
        session.close();
    }
}
