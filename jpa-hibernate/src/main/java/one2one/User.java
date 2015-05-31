package one2one;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Dmitry Shnurenko
 */
@Entity(name = "user")
public class User implements Serializable {
    @Id
    @Column(name = "id")
    private int     id;
    @Column(name = "name")
    private String  name;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date    hireDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return id == user.id && !(address != null ? !address
                .equals(user.address) : user.address != null) && !(hireDate != null ? !hireDate
                .equals(user.hireDate) : user.hireDate != null) && name.equals(user.name);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
