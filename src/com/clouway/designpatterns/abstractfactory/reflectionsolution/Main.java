package com.clouway.designpatterns.abstractfactory.reflectionsolution;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {

    HousePart window = new MaterialHousePartFactory().createInstance("Window");
    HousePart door = new MaterialHousePartFactory().createInstance("Door");
  }
}
