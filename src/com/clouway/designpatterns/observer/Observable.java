package com.clouway.designpatterns.observer;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface Observable {
  void addObserver(Observer observer);
}
