package com.clouway.gui.thirdcalculator;

import javax.swing.*;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface ButtonCreatorInterface {
  List<JButton> createButtons(String[] buttonList);
}
