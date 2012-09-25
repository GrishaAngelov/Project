package com.clouway.designpatterns.abstractfactory.factorymethodsolution;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DoorFactory implements HousePartFactory {
  @Override
  public HousePart createPart() {
    return new Door();
  }
}
