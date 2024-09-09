package org.example.repositories;

import org.example.entities.Member;
import org.example.entities.Progress;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProgressRepository {
    public void save(Progress progress){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(progress);
        session.getTransaction().commit();
        session.close();
    }
    public Progress findById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Progress progress = session.get(Progress.class, id);

        session.getTransaction().commit();

        session.close();
        return progress;
    }
    public void update(Progress progress) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.update(progress);

        session.getTransaction().commit();
        session.close();
    }
    public void delete(Progress progress) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        if(progress != null){
            session.delete(progress);
        }
        session.getTransaction().commit();

        session.close();
    }
}
