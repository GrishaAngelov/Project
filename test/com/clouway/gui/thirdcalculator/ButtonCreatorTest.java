package com.clouway.gui.thirdcalculator;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ButtonCreatorTest {

  private ButtonCreator buttonCreator;

  @Before
  public void setUp(){
    buttonCreator = new ButtonCreator();
  }

  @Test
  public void createButtons(){
    int size = buttonCreator.createButtons(new String[] {"1"}).size();
    assertEquals(1,size);
  }

  @Test
  public void createSequenceInvocationsButtons(){
    int size = buttonCreator.createButtons(new String[] {"1","2","3"}).size();
    assertEquals(3,size);

    size = buttonCreator.createButtons(new String[] {"1","2","3"}).size();
    assertEquals(3,size);
  }

}
