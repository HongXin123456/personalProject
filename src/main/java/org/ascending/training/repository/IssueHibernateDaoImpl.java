package org.ascending.training.repository;

import org.ascending.training.model.Issue;
import org.hibernate.*;
import org.ascending.training.Util.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class IssueHibernateDaoImpl implements IIssueDao{
    private static final Logger logger = LoggerFactory.getLogger(IssueHibernateDaoImpl.class);
    @Override
    public void save(Issue issue) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try{
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(issue); //press "command" and click "save" in the code. or google "session save"
            //.save() is an API
            transaction.commit();
            session.close();

        } catch(HibernateException e) {
            logger.error("Save Transaction failed. Rollback");
            if (transaction != null){
                transaction.rollback();
            }
            logger.error("Unable to save department or unable to close session", e);
        }

    }

    @Override
    public List<Issue> getIssues() {
        logger.info("Start to getDepartments from Postgres via Hibernate.");

        List<Issue> issues = new ArrayList<>();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try{
            Session session = sessionFactory.openSession();

            String hql = "from Issue";
            Query<Issue> query = session.createQuery(hql);

            issues = query.list();

            session.close();
        } catch (HibernateException e){
            logger.error("Open session exception or class session exception", e);

        }

        logger.info("Get Issues {}", issues);
        return issues;
    }

    @Override
    public Issue getById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Issue issue) {SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(issue);
            transaction.commit();
            session.close();
        }catch(HibernateException e){
            logger.error("Delete Transaction failed. Rollback");
            if (transaction != null){
                transaction.rollback();
            }
            logger.error("Unable to delete issues or unable to close session", e);
        }
        return true;

    }


    public Issue getIssueEagerBy(Long id) {
        String hql = "FROM Department d LEFT JOIN FETCH d.employees where d.id = :Id"; //LEFT JOIN FETCH: HQL里面的left join
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Issue> query = session.createQuery(hql);
            query.setParameter("Id", id);
            Issue result = query.uniqueResult();
            session.close();
            return result;
        } catch (HibernateException e) {
            logger.error("failed to retrieve data record", e);
            session.close();
            return null;
        }
    }
}
