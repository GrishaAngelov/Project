package com.clouway.gui.calculatortask;

import javax.swing.*;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface ButtonBuilderInterface {
  List<JButton> createButtons(String[] buttonList);
}