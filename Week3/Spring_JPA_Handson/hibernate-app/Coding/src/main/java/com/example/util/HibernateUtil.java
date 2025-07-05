package com.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.example.model.Employee; // ✅ Import your model class

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // ✅ Register the annotated class explicitly
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Employee.class);  // ← THIS was missing

            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
