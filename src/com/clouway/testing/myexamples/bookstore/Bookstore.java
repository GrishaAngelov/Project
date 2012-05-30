package com.clouway.testing.myexamples.bookstore;

import java.util.Map;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Bookstore {
  private Map<Long, Book> bookStore;

  public Bookstore(Map<Long, Book> bookStore) {
    this.bookStore = bookStore;
  }

  public void addBook(Long isbn, Book book) {
    if (!bookStore.containsKey(isbn) && !bookStore.containsValue(book)) {
      bookStore.put(isbn, book);
    } else {
      throw new DuplicateBookException();
    }
  }

  public int getBookStoreSize() {
    return bookStore.entrySet().size();
  }

  public Map<Long, Book> getAllBooks() {
    return bookStore;
  }
}
