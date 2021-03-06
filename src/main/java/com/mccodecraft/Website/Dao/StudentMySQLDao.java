package com.mccodecraft.Website.Dao;

import com.mccodecraft.Website.DbObjects.Parent;
import com.mccodecraft.Website.DbObjects.Student;
import com.mccodecraft.Website.DbService.StudentDbService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by james on 3/14/17.
 */
public class StudentMySQLDao <S extends Parent, T extends Student> implements StudentDbService<S,T> {
    private static SessionFactory factory = null;
    private Transaction tx = null;
    private Session session = null;


    @Override
    public Integer create(S thing, T entity) {
        Integer sID = null;
        try {
            factory = new Configuration().addAnnotatedClass(Student.class).configure().buildSessionFactory();
            Session session = factory.openSession();
            tx = session.beginTransaction();
            Student student = new Student()
                    .setfName(entity.getfName())
                    .setpName(entity.getpName())
                    .setlName(entity.getlName())
                    .setpWord(entity.getpWord())
                    .setIsDeleted(false)
                    .setJoinDate();

//            thing.setStudents(new ArrayList<Student>());
//            thing.getStudents().add(student);
            session.save(thing);
            sID  = student.getSId();
            tx.commit();
            session.close();
        } catch (HibernateException exception) {
            exception.printStackTrace();
            return null;
        }
        return sID;
    }

    @Override
    public T read(Integer sID) {
        factory = new Configuration().addAnnotatedClass(Student.class).configure().buildSessionFactory();
        Session session  = factory.openSession();
        Transaction tx = session.beginTransaction();

        try{
            Student aStudent= (Student) session.get(Student.class, sID);
            tx.commit();
            session.close();
            return (T) aStudent;
        } catch (HibernateException e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Boolean update(Parent parent, Integer sId, String psName, String fsName, String lsName, String psWord,
                          Date sjoinDate) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Student student = session.get(Student.class, sId);
            student.setpName(psName)
                    .setfName(fsName)
                    .setlName(lsName)
                    .setpWord(psWord)
                    .setJoinDate(sjoinDate);
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
    public Boolean delete(Integer sId) {
        //similar to update, just setting isDeleted and adding a deleted date (date is set in parent object).
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Student student = session.get(Student.class, sId);
            student.setIsDeleted(true);
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
