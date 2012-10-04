package com.clouway.designpatterns.observer;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Product {
  private String name;

  public Product(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
