package com.mccodecraft.Website.Dao;

import com.mccodecraft.Website.DbObjects.Student;
import com.mccodecraft.Website.DbObjects.VideoObject;
import com.mccodecraft.Website.DbService.VideoDbService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by james on 3/14/17.
 */
public class VideoMySQLDao<T extends VideoObject> implements VideoDbService<T> {
    private static SessionFactory factory = null;

    @Override
    public Integer create(T entity) {
        factory = new Configuration().addAnnotatedClass(VideoObject.class).configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Integer qVideoID = null;

        VideoObject video = new VideoObject()
                .setVideoId(entity.getVideoId())
                .setVideoName(entity.getVideoName())
                .setVideoDesc(entity.getVideoDesc())
                .setYoutubeLink(entity.getYoutubeLink())

        qVideoID = (Integer) session.save(video);
        //todo figure out how to have video create return quantified video value
        return qVideoID;
    }

    @Override
    public T read(Integer vID) {
        factory = new Configuration().addAnnotatedClass(VideoObject.class).configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        if (vID > 100) {
            try {
                VideoObject videoObj = (VideoObject) session.get(VideoObject.class, vID);
                tx.commit();
                session.close();
                return (T) videoObj;
            } catch (HibernateException e) {
                e.printStackTrace();
                session.getTransaction().rollback();
            }

        }
        //todo: throw error due to videoObject not being correct. (10 vs 110)
        return null;
    }

    @Override
    public Boolean update(T entity) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            VideoObject videoObject = session.get(VideoObject.class, entity.getQuantifiedVideoID());
            videoObject
                    .setVideoId(entity.getVideoId())
                    .setVideoName(entity.getVideoName())
                    .setVideoDesc(entity.getVideoDesc())
                    .setYoutubeLink(entity.getYoutubeLink())
                    .setCourseId(entity.getCourseId())
                    .setCourseName(entity.getCourseName())
                    .setCourseDesc(entity.getCourseDesc())
                    .setQuantifiedVideoID(entity.getQuantifiedVideoID());
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
