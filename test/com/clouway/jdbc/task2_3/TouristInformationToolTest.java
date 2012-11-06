package com.clouway.jdbc.task2_3;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TouristInformationToolTest {
    private String URL = "jdbc:mysql://localhost:3306/Tourist";
    private String USERNAME = "root";
    private String PASSWORD = "123456";
    private TouristInformationTool informationTool;
    private Connection connection;
    private Statement statement;

    @Before
    public void setUp() throws SQLException {
        informationTool = new TouristInformationTool();
        informationTool.configureDataSource(URL, USERNAME, PASSWORD);

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(URL);
        dataSource.setUser(USERNAME);
        dataSource.setPassword(PASSWORD);
        connection = dataSource.getConnection();
        statement = connection.createStatement();
        fillTables();
    }

    @After
    public void tearDown() throws SQLException, FileNotFoundException {
        informationTool.close();
        statement.close();
        connection.close();
    }

    @Test
    public void insertIntoPeople() throws Exception {
        String query = "SELECT * FROM people";
        int countedRowsBeforeInsert = countRowsInResultSet(statement.executeQuery(query));
        informationTool.insertIntoPeople("testPerson", "1234567890", 32, "mail@mail.com");
        int countedRowsAfterInsert = countRowsInResultSet(statement.executeQuery(query));
        assertThat(countedRowsAfterInsert, is(countedRowsBeforeInsert + 1));
    }

    @Test
    public void insertIntoTrip() throws SQLException {
        String query = "SELECT * FROM trip";
        int countedRowsBeforeInsert = countRowsInResultSet(statement.executeQuery(query));
        informationTool.insertIntoTrip("8510162147","2012-10-20","2012-10-25","New York");
        int countedRowsAfterInsert = countRowsInResultSet(statement.executeQuery(query));
        assertThat(countedRowsAfterInsert, is(countedRowsBeforeInsert + 1));
    }

    @Test
    public void updateTable() throws SQLException {
        int countUpdatedRows = informationTool.updateTable("people", "email", "\"diana_d@mail.com\"", "email=\"diana@mail.com\"");
        assertThat(1, is(countUpdatedRows));
    }


    @Test
    public void getAllNamesByFirstLetters() throws SQLException {
        List<String> nameList = informationTool.getAllNamesThatStartWith("J");
        assertThat(Arrays.asList("John", "James"), is(nameList));
    }

    @Test
    public void getAllNamesThatAreInTheSameCityOnSameDate() throws SQLException {
        List<String> nameList = informationTool.getAllNamesInRange("2012-10-18", "2012-10-25", "Boston");
        assertThat(Arrays.asList("Peter", "Kelly", "Tina"), is(nameList));
    }

    @Test
    public void getAllCitiesInDescendantOrderBasedOnVisits() throws SQLException {
        List<String> cityList = informationTool.getAllCitiesOrderByVisitsDesc();
        assertThat(Arrays.asList("Washington", "Boston", "New York"), is(cityList));
    }

    @Test
    public void deleteContentOfTable() throws SQLException {
        informationTool.deleteContentOf("people");
        ResultSet resultSet = statement.executeQuery("SELECT * FROM people");
        assertFalse(resultSet.first());
    }

    @Test
    public void deleteTable() throws SQLException {
        int countedTablesBeforeDelete = countTablesInDB("Tourist");
        informationTool.deleteTable("people");
        int countedTablesAfterDelete = countTablesInDB("Tourist");
        assertThat(countedTablesAfterDelete, is(countedTablesBeforeDelete - 1));
    }

    private int countRowsInResultSet(ResultSet resultSet) throws SQLException {
        int count = 0;
        while (resultSet.next()) {
            count++;
        }
        return count;
    }

    private int countTablesInDB(String databaseName) throws SQLException {
        int countTables = 0;
        String countTablesQuery = "SELECT COUNT(*) AS count FROM information_schema.tables WHERE table_schema='" + databaseName + "'";

        ResultSet resultSet = statement.executeQuery(countTablesQuery);
        if (resultSet.next()) {
            countTables = Integer.parseInt(resultSet.getString("count"));
        }
        return countTables;
    }

    private void fillTables() throws SQLException {
        statement.addBatch("DROP TABLE IF EXISTS people");
        statement.addBatch("DROP TABLE IF EXISTS trip");
        statement.addBatch("create table people (name VARCHAR(20),egn VARCHAR (10) NOT NULL,PRIMARY KEY (egn), age INTEGER, email VARCHAR(30))");
        statement.addBatch("insert into people values (\"John\",\"8912103265\",23,\"john@mail.com\")");
        statement.addBatch("insert into people values (\"James\",\"8710122354\",25,\"james@mail.com\")");
        statement.addBatch("insert into people values (\"Peter\",\"8218122165\",30,\"peter@mail.com\")");
        statement.addBatch("insert into people values (\"Kelly\",\"8715122354\",25,\"kelly@mail.com\")");
        statement.addBatch("insert into people values (\"Tina\",\"8410122354\",28,\"tina@mail.com\")");
        statement.addBatch("insert into people values (\"Diana\",\"8405122354\",28,\"diana@mail.com\")");
        statement.addBatch("insert into people values (\"Robin\",\"8405182354\",28,\"robin@mail.com\")");
        statement.addBatch("insert into people values (\"Steve\",\"8405212354\",28,\"steve@mail.com\")");
        statement.addBatch("insert into people values (\"Simon\",\"8405232354\",28,\"simon@mail.com\")");
        statement.addBatch("create table trip (egn VARCHAR(10) NOT NULL, FOREIGN KEY (egn) REFERENCES people(egn), arrive_date DATE, leave_date DATE, city VARCHAR(20))");
        statement.addBatch("insert into trip values (\"8912103265\",'2012-10-18','2012-10-22',\"New York\")");
        statement.addBatch("insert into trip values (\"8710122354\",'2012-10-18','2012-10-22',\"New York\")");
        statement.addBatch("insert into trip values (\"8218122165\",'2012-10-18','2012-10-25',\"Boston\")");
        statement.addBatch("insert into trip values (\"8715122354\",'2012-10-18','2012-10-25',\"Boston\")");
        statement.addBatch("insert into trip values (\"8410122354\",'2012-10-18','2012-10-25',\"Boston\")");
        statement.addBatch("insert into trip values (\"8405122354\",'2012-10-18','2012-10-25',\"Washington\")");
        statement.addBatch("insert into trip values (\"8405182354\",'2012-10-18','2012-10-25',\"Washington\")");
        statement.addBatch("insert into trip values (\"8405212354\",'2012-10-18','2012-10-25',\"Washington\")");
        statement.addBatch("insert into trip values (\"8405232354\",'2012-10-18','2012-10-25',\"Washington\")");
        statement.executeBatch();
    }
}
