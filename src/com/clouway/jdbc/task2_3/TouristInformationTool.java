package com.clouway.jdbc.task2_3;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TouristInformationTool {
  private MysqlDataSource mysqlDataSource;
  private Connection connection;
  private Statement statement;

  public void configureDataSource(String url, String username, String password) throws SQLException {
    mysqlDataSource = new MysqlDataSource();
    mysqlDataSource.setURL(url);
    mysqlDataSource.setUser(username);
    mysqlDataSource.setPassword(password);
    connection = mysqlDataSource.getConnection();
    statement = connection.createStatement();
  }

  public void insertIntoPeople(String name, String egn, int age, String email) throws SQLException {
    String query = String.format("INSERT INTO people VALUES (\"%s\",\"%s\",%d,\"%s\")", name, egn, age, email);
    executeQuery(query);
  }

  public void insertIntoTrip(String egn, String arriveDate, String leaveDate, String city) throws SQLException {
    String query = String.format("INSERT INTO trip VALUES (\"%s\",\"%s\",\"%s\",\"%s\")", egn, arriveDate, leaveDate, city);
    executeQuery(query);
  }

  public int updateTable(String table, String column, String value, String condition) throws SQLException {
    String query = String.format("UPDATE %s SET %s = %s WHERE %s", table, column, value, condition);
    return statement.executeUpdate(query);
  }

  public List<String> getAllNamesThatStartWith(String firstLettersFromName) throws SQLException {
    String query = "SELECT Name FROM people WHERE name LIKE \"" + firstLettersFromName + "%" + "\"";
    ResultSet resultSet = statement.executeQuery(query);

    return getNameList(resultSet, "name");
  }

  public List<String> getAllNamesInRange(String arriveDate, String leaveDate, String city) throws SQLException {
    String query = "SELECT Name FROM people JOIN trip ON people.egn = trip.egn WHERE trip.arrive_date=\"" + arriveDate +
            "\" AND leave_date=\"" + leaveDate + "\" AND trip.city=\"" + city + "\"";
    ResultSet resultSet = statement.executeQuery(query);

    return getNameList(resultSet, "name");
  }

  public List<String> getAllCitiesOrderByVisitsDesc() throws SQLException {
    String query = "SELECT city,count(city) FROM trip GROUP BY city ORDER BY count(city) DESC";
    ResultSet resultSet = statement.executeQuery(query);
    return getNameList(resultSet, "city");
  }

  public void deleteContentOf(String table) throws SQLException {
    String query = "TRUNCATE TABLE " + table;
    statement.execute(query);
  }

  public void deleteTable(String table) throws SQLException {
    String query = "DROP TABLE " + table;
    statement.execute(query);
  }

  public void restoreTables(String path) throws FileNotFoundException, SQLException {
    Scanner scanner = new Scanner(new File(path));
    StringBuilder stringBuilder = new StringBuilder();

    statement.execute("DROP TABLE IF EXISTS people");
    statement.execute("DROP TABLE IF EXISTS trip");
    try {
      while (scanner.hasNext()) {
        stringBuilder.delete(0,stringBuilder.length());
        stringBuilder.append(scanner.nextLine());
        statement.execute(stringBuilder.substring(0, stringBuilder.length() - 1));
      }
    } finally {
      scanner.close();
    }
  }

  private List<String> getNameList(ResultSet resultSet, String column) throws SQLException {
    List<String> nameList = new ArrayList<String>();
    while (resultSet.next()) {
      nameList.add(resultSet.getString(column));
    }
    return nameList;
  }

  private void executeQuery(String query) throws SQLException {
    statement.execute(query);
  }

  public void close() throws SQLException {
    statement.close();
    connection.close();
  }

}
