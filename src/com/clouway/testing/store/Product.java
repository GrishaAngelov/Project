package com.clouway.testing.store;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {

  private String productName;
  private int maxQuantity;
  private int currentQuantity;
  private BigDecimal price;

  /**
   * Constructor that initialize name, maximum quantity and price of the product
   *
   * @param productName
   * @param maxQuantity
   * @param price
   */
  public Product(String productName, int maxQuantity, BigDecimal price) {
    this.productName = productName;
    this.maxQuantity = maxQuantity;
    currentQuantity = maxQuantity;
    this.price = price;
  }

  /**
   * Add the given amount to the current quantity
   *
   * @param q
   */
  public void addQuantity(int q) {
    currentQuantity += q;
  }

  /**
   * Perform selling by removing the given amount from the current quantity
   *
   * @param q
   */
  public void sellQuantity(int q) {
    if (currentQuantity > 0) {
      currentQuantity -= q;
    }
    if (currentQuantity < 0) {
      throw new LackOfProductException();
    }
  }

  /**
   * @return current quantity of product
   */
  public int getCurrentQuantity() {
    return currentQuantity;
  }

  /**
   * @return name of the product
   */
  public String getProductName() {
    return productName;
  }

  /**
   * @return price of the product
   */
  public BigDecimal getProductPrice() {
    return price;
  }
}