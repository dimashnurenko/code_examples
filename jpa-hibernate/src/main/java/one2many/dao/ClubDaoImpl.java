package one2many.dao;

import common.GenericDaoImpl;
import one2many.Club;
import one2one.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Dmitry Shnurenko
 */
public class ClubDaoImpl extends GenericDaoImpl<Club> {

    @Override
    public Club get(Club club) {
        Session session;

        Club clubFromDb = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            clubFromDb = (Club) session.get(Club.class, club.getId());
            Hibernate.initialize(clubFromDb);
            Hibernate.initialize(clubFromDb.getMembers());

            tx.commit();
            session.close();
        } catch (HibernateException exception) {
            exception.printStackTrace();
        }

        return clubFromDb;
    }
}
