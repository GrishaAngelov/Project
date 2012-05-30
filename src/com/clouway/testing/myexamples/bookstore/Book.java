package com.clouway.testing.myexamples.bookstore;

import java.math.BigDecimal;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Book {
  private String author;
  private String title;
  private BigDecimal price;

  public Book(String author, String title, BigDecimal price) {
    this.author = author;
    this.title = title;
    this.price = price;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;

    if (author != null ? !author.equals(book.author) : book.author != null) return false;
    if (price != null ? !price.equals(book.price) : book.price != null) return false;
    if (title != null ? !title.equals(book.title) : book.title != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = author != null ? author.hashCode() : 0;
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    return result;
  }
}
