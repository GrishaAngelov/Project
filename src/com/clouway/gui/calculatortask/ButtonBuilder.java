package com.clouway.gui.calculatortask;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface ButtonBuilder {
  JButton buildButton(String buttonLabel, ActionListener listener);
}