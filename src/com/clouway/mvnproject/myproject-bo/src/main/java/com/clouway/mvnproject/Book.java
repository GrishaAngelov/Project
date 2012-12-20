package com.clouway.mvnproject;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Book {
    private int id;
    private final String title;
    private final String author;
    private final Double price;

    public Book(int id,String title,String author, Double price) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

  public String getBookInfo(){
      return  String.format("%d %s %s %f",id,title, author,price);
  }
}
