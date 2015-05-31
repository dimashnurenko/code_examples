package common;

import one2one.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Dmitry Shnurenko
 */
public abstract class GenericDaoImpl<T> implements GenericDao<T> {
    @Override
    public void save(T user) {
        Session session;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            session.save(user);

            tx.commit();
            session.close();
        } catch (HibernateException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void remove(T user) {
        Session session;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            session.delete(user);

            tx.commit();
            session.close();
        } catch (HibernateException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(T user) {
        Session session;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            session.update(user);

            tx.commit();
            session.close();
        } catch (HibernateException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public abstract T get(T entity);
}
