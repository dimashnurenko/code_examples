package one2many;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dmitry Shnurenko
 */
@Entity
@Table(name = "club")
public class Club implements Serializable {

    @Id
    @Column(name = "id")
    private int         id;
    @Column(name = "name")
    private String      name;
    @OneToMany(mappedBy = "club")
    private Set<Member> members;

    public Club() {
        members = new HashSet<>();
    }

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

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }
}
