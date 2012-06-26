package com.clouway.gui.passwordgenerator;

import javax.swing.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    PasswordGeneratorForm form = new PasswordGeneratorForm();
    form.setLocation(500, 500);
    form.setSize(300, 100);
    form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    form.setVisible(true);
  }
}
