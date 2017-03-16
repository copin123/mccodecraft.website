package com.mccodecraft.Website.Dao;

import com.mccodecraft.Website.DbObjects.CourseObject;
import com.mccodecraft.Website.DbObjects.VideoObject;
import com.mccodecraft.Website.DbService.CourseDbService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by james on 3/14/17.
 */
public class CourseMySQLDao<T extends CourseObject> implements CourseDbService<T> {
    private static SessionFactory factory = null;

    @Override
    public Integer create(T entity) {
        factory = new Configuration().addAnnotatedClass(VideoObject.class).configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Integer courseID = null;

        CourseObject course = new CourseObject()
                .setCourseId(entity.getCourseId())
                .setCourseName(entity.getCourseName())
                .setCourseDesc(entity.getCourseDesc());
        courseID = (Integer) session.save(course);
        return courseID;
    }

    @Override
    public T read(Integer vID) {
        factory = new Configuration().addAnnotatedClass(VideoObject.class).configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();return null;
    }

    @Override
    public Boolean update(T entity) {
        factory = new Configuration().addAnnotatedClass(VideoObject.class).configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();return null;
    }
}
