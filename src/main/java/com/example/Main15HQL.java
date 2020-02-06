package com.example;

import com.example.entity.Husband;
import com.example.entity.School;
import com.example.entity.Student;
import com.example.entity.Wife;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main15HQL {

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Query queryOne = session.createQuery("FROM Husband");
        List<Husband> resultsOne = (List<Husband>) queryOne.getResultList();
        resultsOne.stream().map(Husband::getName).forEach(System.out::println);

        Query queryTwo = session.createQuery("SELECT h.name FROM Husband AS h");
        List<String> resultsTwo = (List<String>) queryTwo.getResultList();
        resultsTwo.forEach(System.out::println);

        Query<Husband> queryThree = session.createQuery("FROM Husband AS h WHERE h.id = :id", Husband.class);
        queryThree.setParameter("id", 4L);
        Husband singleResult = queryThree.getSingleResult();
        System.out.println(singleResult.getName());

        Husband husband = session.createQuery("FROM Husband AS h WHERE h.id = :id", Husband.class)
                .setParameter("id", 4L)
                .getSingleResult();

        System.out.println(husband.getName());

        session.createQuery("select w.name from Husband as h inner join h.wife as w")
                .getResultList()
                .stream()
                .forEach(System.out::println);

        transaction.commit();
        session.close();
    }
}
