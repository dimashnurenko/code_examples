package one2one.util;

import one2many.Club;
import one2many.Member;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author Dmitry Shnurenko
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;


    static {
        try {
            AnnotationConfiguration ac = new AnnotationConfiguration();
            ac.addAnnotatedClass(Club.class).addAnnotatedClass(Member.class);
            sessionFactory = ac.configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
