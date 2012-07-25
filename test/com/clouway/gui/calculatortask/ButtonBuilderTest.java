package com.clouway.gui.calculatortask;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ButtonBuilderTest {
  private ButtonBuilder buttonBuilder;

  @Before
  public void setUp() {
    buttonBuilder = new ButtonBuilder();
  }

  @Test
  public void createButtons() {
    int size = buttonBuilder.createButtons(new String[]{"1"}).size();
    assertEquals(1, size);
  }

  @Test
  public void createSequenceInvocationsButtons() {
    int size = buttonBuilder.createButtons(new String[]{"1", "2", "3"}).size();
    assertEquals(3, size);

    size = buttonBuilder.createButtons(new String[]{"1", "2", "3"}).size();
    assertEquals(3, size);
  }
}
