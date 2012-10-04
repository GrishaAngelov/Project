package com.clouway.designpatterns.observer;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ProductMessageProvider {
  public String provideAddedProductMessage() {
    return " has been added";
  }

  public String provideRemovedProductMessage() {
    return " has been removed";
  }
}
