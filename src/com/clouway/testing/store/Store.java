package com.clouway.testing.store;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Store {

  private List<Product> productList;

  public Store(List<Product> productList) {
    this.productList = productList;
  }

  /**
   * Adds a product to the product list and checks whether it already exists
   *
   * @param product
   */
  public void addProduct(Product product) {
    if (!productList.contains(product)) {
      productList.add(product);
    } else {
      throw new DuplicateProductException();
    }
  }

  /**
   * Sells a certain amount of product
   *
   * @param quantity
   * @param product
   */
  public void sellProduct(int quantity, Product product) {
    if (!productList.isEmpty()) {
      product.sellQuantity(quantity);
    } else {
      throw new LackOfProductException();
    }
  }

  /**
   * Returns the size of the product list
   *
   * @return size
   */
  public int getProductListSize() {
    return productList.size();
  }

  /**
   * Returns sorted by price product list
   */
  public List getSortedByPriceProductList() {
    Collections.sort(productList, new Comparator<Product>() {
      @Override
      public int compare(Product product, Product product1) {
        return product.getProductPrice().compareTo(product1.getProductPrice());
      }
    });
    return productList;
  }
}
