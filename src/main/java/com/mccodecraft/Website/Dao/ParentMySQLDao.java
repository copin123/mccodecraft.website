package com.mccodecraft.Website.Dao;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.mccodecraft.Website.DbObjects.Parent;
import com.mccodecraft.Website.DbService.ParentDbService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static javax.persistence.EntityManagerFactory.*;
import java.sql.*;

/**
 * Created by james on 2/20/17.
 */
public class ParentMySQLDao<T extends Parent> implements ParentDbService<T> {

    //    private Connection conn;
//    private Statement stmnt;
    private static SessionFactory factory = null;

    protected void setUp() throws Exception {
    }

    @Override
    public Integer create(T entity) {
        //new code from http://techpost360.blogspot.se/2015/12/hibernate-5-maven-example.html

        factory = new Configuration().addAnnotatedClass(Parent.class).configure().buildSessionFactory();
        Session session  = factory.openSession();
        Transaction tx = session.beginTransaction();
        Integer pID = null;

         Parent parent = new Parent()
                .setfName(entity.getfName())
                .setlName(entity.getlName())
                .setJoinDate()
                .setpWord(entity.getpWord())
                .setIsDeleted(false)
                .setpName(entity.getpName())
                .setJoinDate();
        pID = (Integer) session.save(parent);
        tx.commit();
        session.close();
        return pID;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T read(Integer pID) {

        factory = new Configuration().addAnnotatedClass(Parent.class).configure().buildSessionFactory();
        Session session  = factory.openSession();
        Transaction tx = session.beginTransaction();

        try{
            Parent aParent= (Parent) session.get(Parent.class, pID);
            tx.commit();
            session.close();
            return (T) aParent;
        } catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }

//        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
//                .configure("com/mccodecraft/Website/resources/hibernate.cfg.xml")
//                .build();
//        Metadata metadata = new MetadataSources(standardRegistry)
//                .addAnnotatedClass(Parent.class)
////                .addAnnotatedClassName()
//                .getMetadataBuilder()
//                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
//                .build();
//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder()
//                .applyBeanManager(getbeanmanagerfromsomewhere()).build();
//        try {
//            sessionFactory = new Configuration().configure().buildSessionFactory();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Transaction tx = null;
//        Parent parent = null;
//        Session session = sessionFactory.openSession();
//        try {
//            tx = session.beginTransaction();
//            parent = session.get(Parent.class, pID);
//        } catch (HibernateException ex) {
//            if (tx != null) tx.rollback();
//            ex.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return (T) parent;
        return null;
    }


    @Override
    public Boolean update(Integer pId, String pName, String fName, String lName, String pWord, String joinDate) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Parent parent = session.get(Parent.class, pId);
            parent.setpName(pName)
                    .setfName(fName)
                    .setlName(lName)
                    .setpWord(pWord)
                    .setJoinDateString(joinDate);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public Boolean delete(Integer pId) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Parent parent = session.get(Parent.class, pId);
            // TODO: 3/4/17 find a solution that isn't as final as deleting the entry in the database.
            session.delete(parent);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) tx.rollback();
            ex.printStackTrace();
            return false;
        } finally {
            session.close();

        }

        return true;
    }
}
