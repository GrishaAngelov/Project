package com.clouway.gui.thirdcalculator;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ComponentAttacher {
  private Container container;
  private List<JButton> buttonList;

  public ComponentAttacher(Container container, List<JButton> buttonList) {
    this.container = container;
    this.buttonList = buttonList;
  }


}
