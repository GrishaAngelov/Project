package com.clouway.xml;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Employer {
    private String name;
    private String startDate;
    private String endDate;


    public Employer(String name, String startDate, String endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
