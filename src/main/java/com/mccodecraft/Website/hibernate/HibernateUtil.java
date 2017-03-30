package com.mccodecraft.Website.hibernate;

import com.mccodecraft.Website.DbObjects.Parent;
import com.mccodecraft.Website.DbObjects.Student;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by james on 3/21/17.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure().addAnnotatedClass(Parent.class).addAnnotatedClass(Student.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }
}
