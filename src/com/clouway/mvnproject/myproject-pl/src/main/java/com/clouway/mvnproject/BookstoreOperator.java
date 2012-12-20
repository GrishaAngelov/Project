package com.clouway.mvnproject;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class BookstoreOperator {
    private Statement statement;

    public void configureDataSource(String user, String url, String password) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser(user);
        dataSource.setURL(url);
        dataSource.setPassword(password);
        statement=dataSource.getConnection().createStatement();
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> bookList = new ArrayList<Book>();

        String selectQuery = "SELECT * from book";
        ResultSet rs=  statement.executeQuery(selectQuery);
        while (rs.next()){
            bookList.add(new Book(rs.getInt("id"), rs.getString("title"),rs.getString("author"),rs.getDouble("price")));
        }
        return bookList;
    }

}
