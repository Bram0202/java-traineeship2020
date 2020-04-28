package domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address extends AbstractEntity {
    private String streetName;
    private int houseNumber;
    private String postalCode;
    private String Country;

    public Address() {}
}
