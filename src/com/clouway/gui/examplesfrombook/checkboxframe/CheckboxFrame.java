package com.clouway.gui.examplesfrombook.checkboxframe;

import javax.swing.*;
import java.awt.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class CheckboxFrame extends JFrame {
  private JTextField textField;
  private JCheckBox boldCheckbox;
  private JCheckBox italicCheckbox;
  private CheckboxHandler checkboxHandler;

  public CheckboxFrame() {
    super("Checkbox Example");
    setLayout(new FlowLayout());

    textField = new JTextField("This is sample text", 20);
    textField.setHorizontalAlignment(SwingConstants.CENTER);
    textField.setEditable(false);
    add(textField);

    boldCheckbox = new JCheckBox("Bold");
    add(boldCheckbox);
    italicCheckbox = new JCheckBox("Italic");
    add(italicCheckbox);

    checkboxHandler = new CheckboxHandler();
    checkboxHandler.setCheckbox(boldCheckbox, italicCheckbox);
    checkboxHandler.setTextfield(textField);
    boldCheckbox.addItemListener(checkboxHandler);
    italicCheckbox.addItemListener(checkboxHandler);
  }
}
