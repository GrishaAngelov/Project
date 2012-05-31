package com.clouway.testing.myexamples.bookstore;

import java.math.BigDecimal;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Book {
  private String author;
  private String title;
  private BigDecimal price;
  private Long isbn;
  private int currentQuantity;

  public Book(String author, String title, BigDecimal price, Long isbn, int quantity) {
    this.author = author;
    this.title = title;
    this.price = price;
    this.isbn = isbn;
    this.currentQuantity = quantity;
  }

  public void addQuantity(int quantity){
    currentQuantity += quantity;
  }

  public void sellQuantity(int quantity){
     currentQuantity -= quantity;
   }

  public String getAuthor() {
    return author;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public String getTitle() {
    return title;
  }

  public Long getIsbn() {
    return isbn;
  }

  public int getQuantity() {
    return currentQuantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;

    if (currentQuantity != book.currentQuantity) return false;
    if (author != null ? !author.equals(book.author) : book.author != null) return false;
    if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
    if (price != null ? !price.equals(book.price) : book.price != null) return false;
    if (title != null ? !title.equals(book.title) : book.title != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = author != null ? author.hashCode() : 0;
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
    result = 31 * result + currentQuantity;
    return result;
  }
}
