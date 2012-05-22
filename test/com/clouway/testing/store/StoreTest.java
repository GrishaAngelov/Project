package com.clouway.testing.store;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class StoreTest {

  private Store store;
  private Product product;
  private List<Product> productList = new ArrayList<Product>();

  @Before
  public void createStore() {
    store = new Store(productList);
  }

  @Before
  public void createProduct() {
    product = new Product("apples", 10, new BigDecimal("2.99"));
  }

  @Test
  public void testAddProduct() {
    store.addProduct(product);
    assertEquals(1, store.getProductList().size());
  }

  @Test(expected = DuplicateProductException.class)
  public void testAddDuplicateProduct() {
    store.addProduct(product);
    store.addProduct(product);
//
//    Product p = new Product("apples", 10, new BigDecimal("2.99"));
//    store.addProduct(p);
  }

  @Test
  public void testSellSomeProducts() {
    store.addProduct(product);
    store.sellProduct(2, product);
    assertEquals(8, product.getCurrentQuantity());
  }

  @Test
  public void testSellEntireProducts() {
    store.addProduct(product);
    store.sellProduct(10, product);
    assertEquals(0, product.getCurrentQuantity());
  }

  @Test(expected = LackOfProductException.class)
  public void testSellMoreThanYouHave() {
    store.addProduct(product);
    store.sellProduct(15, product);
    assertEquals(-5, product.getCurrentQuantity());
  }

  @Test (expected = LackOfProductException.class)
  public void testSellNotAvailableProduct(){
    store.sellProduct(5,product);
  }
}
