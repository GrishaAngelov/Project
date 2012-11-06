package com.clouway.jdbc.task2_4;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Address {
    private int addressID;
    private String street;
    private String streetNumber;

    public Address(int addressID, String street, String streetNumber) {
        this.addressID = addressID;
        this.street = street;
        this.streetNumber = streetNumber;
    }
}
