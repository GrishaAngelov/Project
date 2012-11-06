package com.clouway.jdbc.task2_1;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class BookstoreOperator {
    private Statement statement;
    private Connection connection;

    public void configureDataSource(String url, String username, String password) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        connection = dataSource.getConnection();
        statement = connection.createStatement();
    }

    public void createTable(String name, String definition) throws SQLException {
        statement.execute("CREATE TABLE " + name + "(" + definition + ")");
    }

    public ResultSet selectFromBookTable(String condition) throws SQLException {
        String selectQuery = "SELECT " + condition;
        return statement.executeQuery(selectQuery);
    }

    public int updateBook(String updateCondition) throws SQLException {
        String updateQuery = "UPDATE book"  + " SET " + updateCondition;
        return statement.executeUpdate(updateQuery);
    }

    public void deleteFromBook(String condition) throws SQLException {
        String deleteQuery = "DELETE FROM book WHERE " + condition;
        statement.execute(deleteQuery);
    }

    public void insertBook(String title, String author, String price) throws SQLException {
        statement.executeUpdate("INSERT INTO book" + " VALUES (null" + ",\"" + title + "\",\"" + author + "\",\"" + price + "\")");
    }

    public void dropTable(String table) throws SQLException {
        String dropTableQuery = "DROP TABLE IF EXISTS " + table;
        statement.execute(dropTableQuery);
    }

    public void addColumnToTable(String table, String column, String columnDefinition) throws SQLException {
        String addColumnQuery = "ALTER TABLE " + table + " ADD " + column + " " + columnDefinition;
        statement.executeUpdate(addColumnQuery);
    }

    public void deleteColumnFromTable(String table, String column) throws SQLException {
        String deleteColumnQuery = "ALTER TABLE " + table + " DROP " + column;
        statement.executeUpdate(deleteColumnQuery);
    }

    public ResultSet findBook(String columns, String likeCondition) throws SQLException {
        String likeQuery = "SELECT " + columns + " FROM book" + " WHERE " + likeCondition;
        return statement.executeQuery(likeQuery);
    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }
}
