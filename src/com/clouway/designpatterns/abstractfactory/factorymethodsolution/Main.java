package com.clouway.designpatterns.abstractfactory.factorymethodsolution;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    HousePart window = new WindowFactory().createPart();
    HousePart door = new DoorFactory().createPart();
  }
}
