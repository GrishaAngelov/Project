package com.clouway.xml;

import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private String position;
    private List<Employer> employerList;
    private List<Address> addressList;

    public Employee(String firstName, String lastName, int age, String position, List<Employer> employerList, List<Address> addressList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.position = position;
        this.employerList = employerList;
        this.addressList = addressList;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public List<Employer> getEmployerList() {
        return employerList;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

}
