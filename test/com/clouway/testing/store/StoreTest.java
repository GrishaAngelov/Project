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
    product = new Product("apples", 10, new BigDecimal("20.99"));
  }

  @Test
  public void testAddProduct() {
    store.addProduct(product);
    assertEquals(1, productList.size());
  }

  @Test(expected = DuplicateProductException.class)
  public void testProductDuplicationIsNotAllowed() {
    store.addProduct(product);
    store.addProduct(product);
  }

  @Test
  public void testAddProductQuantity() {
    store.addProduct(product);
    store.addProductQuantity(2, product);
    assertEquals(12, product.getCurrentQuantity());
  }

  @Test(expected = LackOfProductException.class)
  public void testAddQuantityToNotAvailableProduct() {
    store.addProductQuantity(2, product);
  }

  @Test
  public void testSellSomeQuantityOfProduct() {
    store.addProduct(product);
    store.sellProductQuantity(2, product);
    assertEquals(8, product.getCurrentQuantity());
  }

  @Test
  public void testSellEntireQuantityOfProduct() {
    store.addProduct(product);
    store.sellProductQuantity(10, product);
    assertEquals(0, product.getCurrentQuantity());
  }

  @Test(expected = LackOfProductException.class)
  public void testSellMoreQuantityThanYouHave() {
    store.addProduct(product);
    store.sellProductQuantity(15, product);
    assertEquals(-5, product.getCurrentQuantity());
  }

  @Test(expected = LackOfProductException.class)
  public void testSellQuantityFromNotAvailableProduct() {
    store.sellProductQuantity(5, product);
  }

  @Test
  public void testSortingByPrice() {
    store.addProduct(product);
    Product expensiveProduct = new Product("Chocolate", 10, new BigDecimal("12.50"));
    store.addProduct(expensiveProduct);
    List<Product> productShelf = store.getSortedByPriceProductList();
    double priceFirstProduct = Double.parseDouble(productShelf.get(0).getProductPrice().toString());
    double priceSecondProduct = Double.parseDouble(productShelf.get(1).getProductPrice().toString());
    assertTrue(priceFirstProduct < priceSecondProduct);
  }
}
