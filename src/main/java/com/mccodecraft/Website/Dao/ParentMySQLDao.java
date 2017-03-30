package com.mccodecraft.Website.Dao;

import com.mccodecraft.Website.DbObjects.Parent;
import com.mccodecraft.Website.DbService.ParentDbService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

/**
 * Created by james on 2/20/17.
 */
public class ParentMySQLDao<T extends Parent> implements ParentDbService<T> {
    private static SessionFactory factory = null;

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
                .setpWord(entity.getpWord())
                .setIsDeleted(false)
                .setpName(entity.getpName())
                .setJoinDate(new Date());
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
            Parent aParent = (Parent) session.get(Parent.class, pID);
            tx.commit();
            session.close();
            return (T) aParent;
        } catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }


    @Override
    public Boolean update(Integer pId, String pName, String fName, String lName, String pWord) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Parent parent = session.get(Parent.class, pId);
            parent.setpName(pName)
                    .setfName(fName)
                    .setlName(lName)
                    .setpWord(pWord);
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
        //similar to update, just setting isDeleted and adding a deleted date (date is set in parent object).
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Parent parent = session.get(Parent.class, pId);
            parent.setIsDeleted(true);
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
