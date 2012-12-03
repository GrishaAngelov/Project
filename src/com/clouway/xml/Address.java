package com.clouway.xml;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Address {
    private String street;
    private int streetNo;
    private int section;
    private String city;

    public Address(String street, int streetNo, int section, String city) {
        this.street = street;
        this.streetNo = streetNo;
        this.section = section;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public int getStreetNo() {
        return streetNo;
    }

    public int getSection() {
        return section;
    }

    public String getCity() {
        return city;
    }
}
