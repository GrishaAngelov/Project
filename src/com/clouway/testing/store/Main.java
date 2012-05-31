package com.clouway.testing.store;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    List productArrayList = new ArrayList<Product>();
    Store store = new Store(productArrayList);

    Product p1 = new Product("orange guice", 10, new BigDecimal("15.99"));
    store.addProduct(p1);
    System.out.printf("initial quantity of %s: %d\n", p1.getProductName(), p1.getCurrentQuantity());
    System.out.println("sell 5");
    store.sellProductQuantity(5, p1);
    System.out.printf("product name: %s(%s lv)\ncurrent quantity: %d\n",
            p1.getProductName(), p1.getProductPrice(), p1.getCurrentQuantity());
    System.out.println("add 3");
    p1.addQuantity(3);
    System.out.printf("product name: %s(%s lv)\ncurrent quantity: %d\n\n",
            p1.getProductName(), p1.getProductPrice(), p1.getCurrentQuantity());


    Product p2 = new Product("pizza", 15, new BigDecimal("5.50"));
    store.addProduct(p2);
    System.out.printf("initial quantity of %s: %d\n", p2.getProductName(), p2.getCurrentQuantity());
    System.out.printf("product name: %s(%s lv)\ncurrent quantity: %d\n",
            p2.getProductName(), p2.getProductPrice(), p2.getCurrentQuantity());

//    Product p3 = new Product("icecream", 5, new BigDecimal("15.50"));
//    store.addProduct(p3);
//    System.out.printf("initial quantity of %s: %d\n", p3.getProductName(), p3.getCurrentQuantity());
//    store.sellProduct(10, p3);
//    System.out.printf("product name: %s(%s)\ncurrent quantity: %d\n",
//            p3.getProductName(),p3.getProductPrice(), p3.getCurrentQuantity());

    List<Product> mySortedProductList = store.getSortedByPriceProductList();
    System.out.println("\n-------Store Products Sorted by Price-------");
    for (Product productItem : mySortedProductList) {
      System.out.printf("product name: %s\nprice: %s\n\n", productItem.getProductName(), productItem.getProductPrice());
    }
  }
}