package org.example.repositories;

import org.example.entities.Member;
import org.example.entities.Subscription;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SubscriptionRepository {
    public void save(Subscription subscription){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(subscription);

        session.getTransaction().commit();
        session.close();
    }

    public Subscription findById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Subscription subscription = session.get(Subscription.class, id);

        session.getTransaction().commit();

        session.close();
        return subscription;
    }

    public void update(Subscription subscription) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.update(subscription);

        session.getTransaction().commit();
        session.close();
    }

    public void delete(Member subscription) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        if(subscription != null){
            session.delete(subscription);
        }
        session.getTransaction().commit();

        session.close();
    }
}
