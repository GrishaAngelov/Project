package com.clouway.gui.passwordgenerator;

import javax.swing.*;
import java.awt.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class PasswordGeneratorForm extends JFrame {
  private JButton generatePassButton = new JButton();
  private JTextField textField = new JFormattedTextField();
  private JTextField generatedPasswordsCounter = new JTextField();
  private PassButtonHandler handler = new PassButtonHandler();

  public PasswordGeneratorForm() {
    super("Password Generator");
    setLayout(new FlowLayout());
    generatePassButton.setText("Generate Password");
    generatePassButton.addActionListener(handler);
    handler.setTextField(textField);
    textField.setSize(300, 500);
    textField.setColumns(10);
    textField.setEditable(false);
    add(generatePassButton);
    add(textField);
    generatedPasswordsCounter.setColumns(5);
    generatedPasswordsCounter.setEditable(false);
    handler.setCounter(generatedPasswordsCounter);
    add(generatedPasswordsCounter);


//    add(generatePassButton);
  }
}
