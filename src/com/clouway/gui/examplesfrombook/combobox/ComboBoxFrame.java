package com.clouway.gui.examplesfrombook.combobox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ComboBoxFrame extends JFrame {
  private JComboBox imageComboBox;
  private JLabel label;
  private String[] images = {"img1.jpeg","img2.jpeg","img3.jpeg"};
  private Icon[] icons = {
          new ImageIcon(getClass().getResource(images[0])),
          new ImageIcon(getClass().getResource(images[1])),
          new ImageIcon(getClass().getResource(images[2])),
  };

  public ComboBoxFrame(){
    super("Combobox Frame");
    setLayout(new FlowLayout());

    imageComboBox = new JComboBox(images);
    imageComboBox.setMaximumRowCount(3);
    imageComboBox.addItemListener(
            new ItemListener() {
              public void itemStateChanged(ItemEvent itemEvent) {
                if(itemEvent.getStateChange() == ItemEvent.SELECTED){
                  label.setIcon(icons[imageComboBox.getSelectedIndex()]);
                }
              }
            }
    );

    add(imageComboBox);
    label = new JLabel(icons[0]);
    add(label);
  }

}
