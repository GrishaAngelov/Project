package com.clouway.gui.thirdcalculator;

import java.awt.*;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ComponentAttacher {
  private Container container;
  private List buttonList;

  public ComponentAttacher(Container container, List buttonList) {
    this.container = container;
    this.buttonList = buttonList;
  }


}
