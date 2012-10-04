package com.clouway.designpatterns.observer;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ProductObserver implements Observer {
  private String notification;

  @Override
  public void receiveNotification(String message) {
    this.notification = message;
  }

  public String getReceivedNotification() {
    return notification;
  }
}
