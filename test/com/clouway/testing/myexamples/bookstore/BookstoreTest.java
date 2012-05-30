package com.clouway.testing.myexamples.bookstore;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class BookstoreTest {
  private Bookstore bookStore;
  private Map<Long, Book> bookList;
  private Book book;

  @Before
  public void SetUp() {
    bookList = new HashMap<Long, Book>();
    bookStore = new Bookstore(bookList);
    book = new Book("Ivan Vazov", "Pod Igoto", new BigDecimal("5.99"));
  }

  @Test
  public void testAddBook() {
    bookStore.addBook(1056L, book);
    assertEquals(1, bookStore.getBookStoreSize());
  }

  @Test(expected = DuplicateBookException.class)
  public void testAddSameBookTwice() {
    bookStore.addBook(1056L, book);
    bookStore.addBook(1056L, book);
  }

  @Test(expected = DuplicateBookException.class)
  public void testAddDuplicateBook() {
    bookStore.addBook(1056L, book);
    Book duplicateBook = new Book("Ivan Vazov", "Pod Igoto", new BigDecimal("5.99"));
    bookStore.addBook(1056L, duplicateBook);
  }

  @Test(expected = DuplicateBookException.class)
  public void testAddDifferentBookWithSameIsbn(){
    bookStore.addBook(1056L,book);
    Book duplicateIsbnBook = new Book("Shakespeare", "Hamlet", new BigDecimal("25.99"));
    bookStore.addBook(1056L,duplicateIsbnBook);
  }

  @Test(expected = DuplicateBookException.class)
  public void testAddDuplicateBookWithDifferentIsbn(){
    bookStore.addBook(1056L,book);
    Book duplicateBook = new Book("Ivan Vazov", "Pod Igoto", new BigDecimal("5.99"));
    bookStore.addBook(6845L, duplicateBook);
  }

  @Test
  public void testAddEmptyBook() {
    Book myBook = new Book(null, null, null);
    bookStore.addBook(null, myBook);
    assertEquals(1, bookStore.getBookStoreSize());
  }
}
