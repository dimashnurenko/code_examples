package one2one.dao;

import one2one.Address;
import one2one.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoImplTest {

    private User        user;
    private UserDaoImpl dao;

    @Before
    public void setUp() {
        dao = new UserDaoImpl();

        user = new User();
        user.setId(1);
        user.setName("Gosha");
        user.setHireDate(new Date());

        Address address = new Address();
        address.setId(user.getId());
        address.setStreet("Lenina");
        address.setHouse("25");

        user.setAddress(address);
    }

    @Test
    public void userShouldBeSaved() {
        dao.save(user);
    }

    @Test
    public void userShouldBeRemoved() {
        dao.remove(user);
    }

    @Test
    public void userShouldBeGet() {
        dao.get(user);
    }

}