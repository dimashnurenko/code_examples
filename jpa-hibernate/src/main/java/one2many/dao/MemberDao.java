package one2many.dao;

import common.GenericDaoImpl;
import one2many.Member;
import one2one.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Dmitry Shnurenko
 */
public class MemberDao extends GenericDaoImpl<Member> {

    @Override
    public Member get(Member entity) {
        Session session;

        Member userFromDb = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            userFromDb = (Member) session.get(Member.class, entity.getId());

            tx.commit();
            session.close();
        } catch (HibernateException exception) {
            exception.printStackTrace();
        }

        return userFromDb;
    }
}
