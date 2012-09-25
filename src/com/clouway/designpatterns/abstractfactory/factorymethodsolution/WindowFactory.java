package com.clouway.designpatterns.abstractfactory.factorymethodsolution;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class WindowFactory implements HousePartFactory {
  @Override
  public HousePart createPart() {
    return new Window();
  }
}
