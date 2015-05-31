package one2one;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Dmitry Shnurenko
 */
@Entity(name = "address")
public class Address implements Serializable {

    @Id
    @Column(name = "address_id")
    private int    id;
    @Column(name = "street")
    private String street;
    @Column(name = "house")
    private String house;

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
