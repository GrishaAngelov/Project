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
    book = new Book("Ivan Vazov", "Pod Igoto", new BigDecimal("5.99"), 1056L, 10);
  }

  @Test
  public void testAddBook() {
    bookStore.addBook(book);
    assertEquals(1, bookStore.getBookStoreSize());
  }

  @Test(expected = DuplicateBookException.class)
  public void testBookDuplicationIsNotAllowed() {
    bookStore.addBook(book);
    bookStore.addBook(book);
  }

  @Test(expected = DuplicateBookException.class)
  public void testAddDuplicateBook() {
    bookStore.addBook(book);
    Book duplicateBook = new Book("Ivan Vazov", "Pod Igoto", new BigDecimal("5.99"), 1056L, 1);
    bookStore.addBook(duplicateBook);
  }

  @Test(expected = DuplicateBookException.class)
  public void testAddDifferentBookWithSameIsbn() {
    bookStore.addBook(book);
    Book duplicateIsbnBook = new Book("Shakespeare", "Hamlet", new BigDecimal("25.99"), 1056L, 1);
    bookStore.addBook(duplicateIsbnBook);
  }

  @Test
  public void testAddEmptyBook() {
    Book myBook = new Book(null, null, null, null, 0);
    bookStore.addBook(myBook);
    assertEquals(1, bookStore.getBookStoreSize());
  }

  @Test
  public void testAddQuantityOfBook() {
    bookStore.addBook(book);
    bookStore.addBookQuantity(9,book);
    assertEquals(19, book.getQuantity());
  }

  @Test
  public void testSellQuantityOfBook() {
    bookStore.addBook(book);
    bookStore.sellBookQuantity(9,book);
    assertEquals(1, book.getQuantity());
  }
}
