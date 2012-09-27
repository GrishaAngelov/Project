package com.clouway.designpatterns.abstractfactory.reflectionsolution;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class FactoryTest {

  @Test
  public void createWindow(){
    HousePart window = new MaterialHousePartFactory().createInstance("Window");
    assertTrue(window instanceof Window);
  }

  @Test
  public void createDoor(){
    HousePart door = new MaterialHousePartFactory().createInstance("Door");
    assertTrue(door instanceof Door);
  }
}
