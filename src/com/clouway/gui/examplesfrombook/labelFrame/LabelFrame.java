package com.clouway.gui.examplesfrombook.labelFrame;


import javax.swing.*;
import java.awt.*;


/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class LabelFrame extends JFrame {

  private JLabel firstTextLabel;
  private JLabel iconLabel;
  private JLabel secondTextLabel;

  public LabelFrame(){
    super("Testing JLabel");
    setLayout(new FlowLayout());

    firstTextLabel = new JLabel("first text label");
    firstTextLabel.setToolTipText("This is firstTextLabel");
    add(firstTextLabel);


    Icon infoIcon = new ImageIcon(getClass().getResource("info.jpg"));
    iconLabel = new JLabel("iconLabel",infoIcon,SwingConstants.LEFT);
    iconLabel.setToolTipText("This is icon label");
    add(iconLabel);

    secondTextLabel = new JLabel();
    secondTextLabel.setText("second text label");
    secondTextLabel.setToolTipText("This is secondTextLabel");
    add(secondTextLabel);
  }

}
