package common;

/**
 * @author Dmitry Shnurenko
 */
public interface GenericDao<T> {

    void save(T user);

    void remove(T user);

    void update(T user);

    T get(T user);
}
