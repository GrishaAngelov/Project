package com.clouway.mvnproject;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class BookShelf {
    public static void main(String[] args) throws SQLException {
        BookstoreOperator operator = new BookstoreOperator();
        operator.configureDataSource("root","jdbc:mysql://localhost:3306/Bookstore","123456");
        List<Book> books = operator.getAllBooks();
        Logger logger = Logger.getLogger("myLogger");

        for(Book book:books){
            logger.info(book.getBookInfo());
        }
    }
}
