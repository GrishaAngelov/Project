package com.clouway.gui.examplesfrombook.listexample;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ListFrame extends JFrame {
  private JList colorList;
  private String[] colorNames = {"Blue", "Green", "Red", "Yellow", "Orange"};
  private Color[] colors = {Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW, Color.ORANGE};

  public ListFrame(){
    super("List Frame");
    setLayout(new FlowLayout());

    colorList = new JList(colorNames);
    colorList.setVisibleRowCount(3);
    colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    add(new JScrollPane(colorList));
    colorList.addListSelectionListener(
            new ListSelectionListener() {

              public void valueChanged(ListSelectionEvent listSelectionEvent) {
                getContentPane().setBackground(colors[colorList.getSelectedIndex()]);
              }
            }
    );
  }
}
