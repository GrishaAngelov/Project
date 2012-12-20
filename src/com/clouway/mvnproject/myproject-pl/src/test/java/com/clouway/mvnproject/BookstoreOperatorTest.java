package com.clouway.mvnproject;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class BookstoreOperatorTest {
    private BookstoreOperator operator;

    @Before
    public void setUp() throws Exception {
        operator = new BookstoreOperator();
        operator.configureDataSource("root","jdbc:mysql://localhost:3306/Bookstore","123456");

    }

    @Test
    public void getAllBooks() throws Exception {
        List<Book> bookList = operator.getAllBooks();
        assertThat(5,is(bookList.size()));

    }
}
