package one2many.dao;

import one2many.Club;
import one2many.Member;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClubDaoImplTest {

    private ClubDaoImpl dao;
    private MemberDao   memberDao;
    private Club        club;

    @Before
    public void setUp() {
        dao = new ClubDaoImpl();
        memberDao = new MemberDao();

        club = new Club();
        club.setId(2);
        club.setName("porno_club");
    }

    @Test
    public void clubShouldBeAdded() {
        dao.save(club);

        Member member1 = new Member();
        member1.setId(1);
        member1.setName("Ivan");
        member1.setClub(club);

        Member member2 = new Member();
        member2.setId(2);
        member2.setName("Petro");
        member2.setClub(club);

        memberDao.save(member1);
        memberDao.save(member2);
    }

    @Test
    public void clubShouldBeGot() {
        Club testClub = dao.get(club);

        for (Member member : testClub.getMembers()) {
            System.out.println(member.getName());
        }
    }

}