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

  public void addBook(Book book) {
    if (!bookStore.containsKey(book.getIsbn()) && !bookStore.containsValue(book)) {
      bookStore.put(book.getIsbn(), book);
    } else {
      throw new DuplicateBookException();
    }
  }

  public void addBookQuantity(int quantity,Book book){
    book.addQuantity(quantity);
  }

  public void sellBookQuantity(int quantity,Book book){
    book.sellQuantity(quantity);
  }

  public int getBookStoreSize() {
    return bookStore.entrySet().size();
  }

  public Map<Long, Book> getAllBooks() {
    return bookStore;
  }
}
