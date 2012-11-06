package com.clouway.jdbc.task2_4;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class RecordsToListConverterTest {
    private String URL="jdbc:mysql://localhost:3306/User";
    private String USER = "root";
    private String PASSWORD = "123456";
    private RecordsToListConverter listConverter;
    private Connection connection;
    private Statement statement;

    @Before
    public void setUp() throws SQLException {
        listConverter = new RecordsToListConverter();
        listConverter.configureDataSource(URL, USER, PASSWORD);

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        connection = dataSource.getConnection();
        statement = connection.createStatement();
    }

    @After
    public void tearDown() throws SQLException {
        listConverter.close();
        connection.close();
        statement.close();
    }

    @Test
    public void getAllUsers() throws SQLException {
        List<User> userList = listConverter.getUserList();
        assertThat(userList.size(), is(countRowsInResultSet(statement.executeQuery("SELECT * FROM user"))));
    }

    @Test
    public void getAllAddresses() throws SQLException {
        List<Address> addressList = listConverter.getAddressList();
        assertThat(addressList.size(), is(countRowsInResultSet(statement.executeQuery("SELECT * FROM address"))));
    }

    @Test
    public void getAllContacts() throws SQLException {
        List<Contact> contactList = listConverter.getContactList();
        assertThat(contactList.size(), is(countRowsInResultSet(statement.executeQuery("SELECT * FROM contact"))));
    }

    private int countRowsInResultSet(ResultSet resultSet) throws SQLException {
        int count = 0;
        while (resultSet.next()) {
            count++;
        }
        return count;
    }
}
