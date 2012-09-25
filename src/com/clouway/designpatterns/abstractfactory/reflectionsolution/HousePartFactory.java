package com.clouway.designpatterns.abstractfactory.reflectionsolution;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface HousePartFactory {
  HousePart createInstance(String instanceName);
}
