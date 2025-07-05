package com.example.app;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.model.Employee;
import com.example.util.HibernateUtil;

public class App {
    public static void main(String[] args) {
        // Create Employee Object
        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setDepartment("HR");

        // Open Hibernate Session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Save the employee object
        session.save(emp);

        // Commit transaction and close session
        tx.commit();
        session.close();

        System.out.println("Employee saved successfully!");
    }
}
