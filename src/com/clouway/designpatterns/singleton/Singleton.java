package com.clouway.designpatterns.singleton;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public final class Singleton {
  private static Singleton instance;

  private Singleton() {

  }

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}
