package org.example.repositories;

import org.example.entities.TrainingSession;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TrainingSessionRepository {

    public void save(TrainingSession trainingSession) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Transaction transaction = session.getTransaction();

        session.save(trainingSession);

        transaction.commit();
        session.close();
    }

    public void update(TrainingSession trainingSession) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(trainingSession);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(TrainingSession trainingSession) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        if (trainingSession != null) {
            session.delete(trainingSession);
        }
        session.getTransaction().commit();
        session.close();
    }

    public TrainingSession findById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        TrainingSession trainingSession = session.get(TrainingSession.class, id);
        session.getTransaction().commit();
        session.close();
        return trainingSession;
    }

}
