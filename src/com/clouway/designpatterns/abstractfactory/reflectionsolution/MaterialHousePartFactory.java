package com.clouway.designpatterns.abstractfactory.reflectionsolution;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MaterialHousePartFactory implements HousePartFactory {
  private HousePart part;

  @Override
  public HousePart createInstance(String instanceName) {

    try {
      part = (HousePart) Class.forName(this.getClass().getPackage().getName() + "." + instanceName).newInstance();
    } catch (ClassNotFoundException ignored) {
    } catch (InstantiationException ignored) {
    } catch (IllegalAccessException ignored) {
    }
    return part;
  }
}
