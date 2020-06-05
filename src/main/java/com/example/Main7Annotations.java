package com.example;

import com.example.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main7Annotations {

    /*
        1.  Opis wybranych adnotacji znajduje się w klasie Employee
        2.  Dwukrotne uruchomienie tego kodu zakończy się wyjątkiem:
            SQLIntegrityConstraintViolationException: Duplicate entry '123456789' for key...
            Jest to spowodowane tym, że telephonNumber jest oznaczony jako unique,
            czyli może istnieć tylko jedna taka wartość w kolumnie
    */

    public static void main(String[] args) throws ParseException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Date birthDate = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998");

        Employee employee = new Employee("Jan", "strongPassword", "123456789", 20, birthDate, Employee.Gender.MALE, "Lore ipsum");
        session.persist(employee);

        transaction.commit();
        session.close();
    }
}
