package com.clouway.networking.downloadagent;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ButtonBuilderTest {
  private ButtonBuilder buttonBuilder;

  @Before
  public void setUp(){
    buttonBuilder = new ButtonBuilder();
  }

  @Test
  public void createButton(){
    JButton button = buttonBuilder.buildButton("myButton");
    assertEquals("myButton",button.getText());
    assertNotNull(button);
  }
}
