package com.clouway.jdbc.task2_2;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TouristDBToolTest {
    private String URL = "jdbc:mysql://localhost:3306/Tourist";
    private String USER = "root";
    private String PASSWORD = "123456";
    private TouristDBTool touristDBTool;
    private Connection connection;
    private Statement statement;

    @Before
    public void setUp() throws SQLException {
        touristDBTool = new TouristDBTool();
        touristDBTool.configureDataSource(URL, USER, PASSWORD);

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        connection = dataSource.getConnection();
        statement = connection.createStatement();
    }

    @After
    public void tearDown() throws SQLException {
        statement.close();
        connection.close();
    }

    @Test
    public void fillDatabaseWithData() throws SQLException {
        statement.execute("DROP TABLE people,trip");
        touristDBTool.fillTouristDB();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM people JOIN trip USING(egn)");
        assertNotNull(resultSet);
    }
}
