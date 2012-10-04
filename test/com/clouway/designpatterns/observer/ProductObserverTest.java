package com.clouway.designpatterns.observer;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ProductObserverTest {
  private ProductObserver productObserver;
  private ProductWarehouse productWarehouse;
  private ProductMessageProvider messageProvider;
  private Product apples;

  @Before
  public void setUp() {
    messageProvider = new ProductMessageProvider();
    productWarehouse = new ProductWarehouse(messageProvider);

    apples = new Product("apples");
    productWarehouse.addProduct(apples);

    productObserver = new ProductObserver();
    productWarehouse.addObserver(productObserver);
  }

  @Test
  public void getNotificationAboutAddedProduct() {
    Product oranges = new Product("oranges");
    productWarehouse.addProduct(oranges);
    assertThat(oranges.getName() + messageProvider.provideAddedProductMessage(), is(productObserver.getReceivedNotification()));
  }

  @Test
  public void getNotificationAboutRemovedProduct() {
    productWarehouse.removeProduct(apples);
    assertThat(apples.getName() + messageProvider.provideRemovedProductMessage(), is(productObserver.getReceivedNotification()));
  }

  @Test(expected = DuplicateProductException.class)
  public void addDuplicateProduct() {
    productWarehouse.addProduct(apples);
  }

  @Test(expected = NoSuchProductException.class)
  public void removeAlreadyRemovedProduct() {
    for (int i = 0; i < 2; i++) {
      productWarehouse.removeProduct(apples);
    }
  }
}
