package com.clouway.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ProductWarehouse implements Observable {
  private List<Product> productList = new ArrayList<Product>();
  private List<Observer> observerList = new ArrayList<Observer>();
  private ProductMessageProvider messageProvider;

  @Override
  public void addObserver(Observer observer) {
    observerList.add(observer);
  }

  public ProductWarehouse(ProductMessageProvider messageProvider) {
    this.messageProvider = messageProvider;
  }

  public void addProduct(Product product) {
    if (!productList.contains(product)) {
      productList.add(product);
      notifyObserversWith(product.getName() + messageProvider.provideAddedProductMessage());
    } else {
      throw new DuplicateProductException();
    }
  }

  public void removeProduct(Product product) {
    if (productList.contains(product)) {
      productList.remove(product);
      notifyObserversWith(product.getName() + messageProvider.provideRemovedProductMessage());
    } else {
      throw new NoSuchProductException();
    }
  }

  private void notifyObserversWith(String message) {
    for (Observer observer : observerList) {
      observer.receiveNotification(message);
    }
  }
}
