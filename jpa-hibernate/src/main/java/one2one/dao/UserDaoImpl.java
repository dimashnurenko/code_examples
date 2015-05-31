package one2one.dao;

import common.GenericDaoImpl;
import one2one.User;
import one2one.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Dmitry Shnurenko
 */
public class UserDaoImpl extends GenericDaoImpl<User> {

    @Override
    public User get(User user) {
        Session session;

        User userFromDb = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            userFromDb = (User) session.get(User.class, user.getId());

            tx.commit();
            session.close();
        } catch (HibernateException exception) {
            exception.printStackTrace();
        }

        return userFromDb;
    }
}
