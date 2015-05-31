package one2many;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Dmitry Shnurenko
 */
@Entity
@Table(name = "member")
public class Member implements Serializable {
    @Id
    @Column(name = "id")
    private int    id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club   club;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Member member = (Member) o;

        return id == member.id && name.equals(member.name);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
