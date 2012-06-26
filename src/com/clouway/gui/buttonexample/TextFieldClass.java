package com.clouway.gui.buttonexample;

import javax.swing.*;
import java.awt.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TextFieldClass extends JFrame {
  private JTextField textField = new JTextField(10);

  public TextFieldClass() {
    super("Text Frame");
    textField.setText("You clicked the button");
    textField.setHorizontalAlignment(SwingConstants.CENTER);
    textField.setEditable(false);
    textField.setFont(new Font( "Serif", Font.PLAIN, 14 ));
    add(textField);
  }
}
