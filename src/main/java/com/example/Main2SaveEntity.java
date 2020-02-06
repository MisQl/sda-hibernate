package com.example;

import com.example.entity.Dog;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main2SaveEntity {

    /*
        1.  Możemy stworzyć strukturę tabeli "dog" w bazie danych
            lub hibernate zrobi to za nas, jeśli mamy ustawioną wartość
            hbm2ddl.auto na update w pliku hibernate.cfg.xml

        2.  Wartość hbm2ddl.auto zawsze powinna być ustawniona na none
            Jedynie w celu prototypowania możemy pozwolić, żeby Hibernate za nas generował strukturę tabeli

            CREATE TABLE dog (
                id BIGINT NOT NULL auto_increment,
                name VARCHAR(255),
                age INT,
                race VARCHAR(255),
                PRIMARY KEY (id)
            )
    */

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(new Dog("Ares",10,"Terier"));
        session.persist(new Dog("Sonia",10,"Bulgod"));
        session.persist(new Dog("Reksio",10,"Doberman"));
        session.persist(new Dog("Benio",10,"Jamnik"));
        session.persist(new Dog("Aza",10,"Wilczur"));

        transaction.commit();
        session.close();
    }
}
