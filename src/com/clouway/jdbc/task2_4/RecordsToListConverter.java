package com.clouway.jdbc.task2_4;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class RecordsToListConverter {
    private Connection connection;
    private Statement statement;

    public void configureDataSource(String url, String username, String password) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        connection = dataSource.getConnection();
        statement = connection.createStatement();
    }

    public List<User> getUserList() throws SQLException {
        ResultSet resultSet = getAllRecordsFrom("user");
        List<User> userList = new ArrayList<User>();
        while (resultSet.next()) {
            userList.add(new User(resultSet.getInt("user_id"), resultSet.getString("username"), resultSet.getString("password")));
        }
        return userList;
    }

    public List<Contact> getContactList() throws SQLException {
        ResultSet resultSet = getAllRecordsFrom("contact");
        List<Contact> contactList = new ArrayList<Contact>();
        while (resultSet.next()) {
            contactList.add(new Contact(resultSet.getInt("contact_id"), resultSet.getString("name")));
        }
        return contactList;
    }

    public List<Address> getAddressList() throws SQLException {
        ResultSet resultSet = getAllRecordsFrom("address");
        List<Address> addressList = new ArrayList<Address>();
        while (resultSet.next()) {
            addressList.add(new Address(resultSet.getInt("address_id"), resultSet.getString("street"), resultSet.getString("street_number")));
        }
        return addressList;
    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }

    private ResultSet getAllRecordsFrom(String table) throws SQLException {
        String query = "SELECT * FROM " + table;
        return statement.executeQuery(query);
    }
}
