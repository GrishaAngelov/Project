package com.clouway.gui.calculatortask;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ButtonBuilderImplTest {
  private ButtonBuilderImpl buttonBuilderImpl;

  @Before
  public void setUp() {
    buttonBuilderImpl = new ButtonBuilderImpl();
  }

  @Test
  public void createButtons() {
    int size = buttonBuilderImpl.buildButtons(new String[]{"1"},new NumbersAndOperationsClickButtonListener(new CalculatorTextFieldImpl(new JTextField()))).size();
    assertEquals(1, size);
  }

  @Test
  public void createSequenceInvocationsButtons() {
    int size = buttonBuilderImpl.buildButtons(new String[]{"1", "2", "3"},new NumbersAndOperationsClickButtonListener(new CalculatorTextFieldImpl(new JTextField()))).size();
    assertEquals(3, size);

    size = buttonBuilderImpl.buildButtons(new String[]{"1", "2", "3"},new NumbersAndOperationsClickButtonListener(new CalculatorTextFieldImpl(new JTextField()))).size();
    assertEquals(3, size);
  }
}
