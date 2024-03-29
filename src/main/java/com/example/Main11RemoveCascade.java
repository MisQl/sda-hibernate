package com.example;

import com.example.entity.Husband;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main11RemoveCascade {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Husband husband = session.find(Husband.class, 2L);
        session.remove(husband);                                    // @OneToOne(cascade = CascadeType.ALL) ustawione w encji husband powoduje, że
                                                                    // session.remove zostanie wywołane dla encji Husband i połączonej z nią encji Wife

        transaction.commit();
        session.close();
    }
}
