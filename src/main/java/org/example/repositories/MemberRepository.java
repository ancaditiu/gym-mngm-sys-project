package org.example.repositories;

import org.example.entities.Member;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MemberRepository {

    public void save(Member member){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(member);

        session.getTransaction().commit();
        session.close();
    }

    public Member findById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Member member = session.get(Member.class, id);

        session.getTransaction().commit();

        session.close();
        return member;
    }

    public void update(Member member) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.update(member);

        session.getTransaction().commit();
        session.close();
    }

    public void delete(Member member) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.delete(member);

        session.getTransaction().commit();

        session.close();
    }


}