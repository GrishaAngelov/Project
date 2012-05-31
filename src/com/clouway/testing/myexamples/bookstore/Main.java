package com.clouway.testing.myexamples.bookstore;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    Map<Long, Book> bookstore = new HashMap<Long, Book>();
    Bookstore myBookstore = new Bookstore(bookstore);
    Book book1 = new Book("John", "bookOne", new BigDecimal("5.70"), 1025L,1);
    Book book2 = new Book("John", "bookOne", new BigDecimal("5.70"), 10254L,1);
    try {
      myBookstore.addBook(book1);
      myBookstore.addBook(book2);

      Map<Long, Book> allBooks = myBookstore.getAllBooks();
      for (Entry<Long, Book> singleBook : allBooks.entrySet()) {
        System.out.println("ISBN: " + singleBook.getValue().getIsbn());
        System.out.println("Author: " + singleBook.getValue().getAuthor());
        System.out.println("Title: " + singleBook.getValue().getTitle());
        System.out.println("Price: " + singleBook.getValue().getPrice());
        System.out.println("---------------------------");
      }
    } catch (DuplicateBookException e) {
      System.out.println(e.getMessage());
    }
  }
}
