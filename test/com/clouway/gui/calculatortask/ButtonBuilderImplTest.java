package com.clouway.gui.calculatortask;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ButtonBuilderImplTest {
  private ButtonBuilder buttonBuilder;

  @Before
  public void setUp() {
    buttonBuilder = new ButtonBuilderImpl();
  }

  @Test
  public void createButton() {
    JButton button = buttonBuilder.buildButton("1",new ClickButtonListener(new CalculatorDisplay(new JTextField())));
    assertEquals("1", button.getText());
  }
}
