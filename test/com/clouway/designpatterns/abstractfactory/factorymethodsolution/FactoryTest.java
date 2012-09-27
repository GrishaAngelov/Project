package com.clouway.designpatterns.abstractfactory.factorymethodsolution;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class FactoryTest {

  private HousePartFactory createFactory(String type) {
    HousePartFactory factory;
    if (type == "window") {
      factory = new WindowFactory();
    } else {
      factory = new DoorFactory();
    }
    return factory;
  }

  @Test
  public void createWindow() {
    HousePartFactory windowFactory = createFactory("window");
    HousePart window = windowFactory.createPart();

    assertTrue(windowFactory instanceof WindowFactory);
    assertTrue(window instanceof Window);
  }

  @Test
  public void createDoor() {
    HousePartFactory doorFactory = createFactory("door");
    HousePart door = doorFactory.createPart();

    assertTrue(doorFactory instanceof DoorFactory);
    assertTrue(door instanceof Door);
  }
}
