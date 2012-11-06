package com.clouway.jdbc.task2_4;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class User {
    private int userID;
    private String username;
    private String password;

    public User(int userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }
}
