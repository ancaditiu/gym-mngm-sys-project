package org.example.repositories;

import org.example.entities.Trainer;
import org.example.entities.TrainingSession;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TrainingSessionRepository {
    public void saveTrainingSession(TrainingSession trainingSession) {


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Transaction transaction = session.getTransaction();


        session.save(trainingSession);

        transaction.commit();
        session.close();

    }
    public void updateTrainingSession(TrainingSession trainingSession) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(trainingSession);
        session.getTransaction().commit();
        session.close();

    }
    public void deleteTrainingSession(TrainingSession trainingSession) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(trainingSession);
        session.getTransaction().commit();
        session.close();//

    }
    public Trainer findById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Trainer trainer = session.get(Trainer.class, id);
        session.getTransaction().commit();
        session.close();
        return trainer;
    }
    public void deleteTrainingSession(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();//1
        session.beginTransaction();
        Trainer trainer = findById(id);
        if (trainer != null) {
            session.delete(trainer);
        }

        session.getTransaction().commit();
        session.close();
    }

}
