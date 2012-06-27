package com.clouway.gui.examplesfrombook.layoutmanagers.flowlayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class FlowLayoutFrame extends JFrame {
  private JButton leftButton;
  private JButton centerButton;
  private JButton rightButton;
  private FlowLayout flowLayout;
  private Container container;

  public FlowLayoutFrame() {
    super("flow layout");
    flowLayout = new FlowLayout();
    container = getContentPane();
    setLayout(flowLayout);

    leftButton = new JButton("Left");
    add(leftButton);
    leftButton.addActionListener(
            new ActionListener() {

              public void actionPerformed(ActionEvent event) {
                flowLayout.setAlignment(FlowLayout.LEFT);
                flowLayout.layoutContainer(container);
              }
            }
    );

    centerButton = new JButton("Center");
    add(centerButton);
    centerButton.addActionListener(
            new ActionListener() {

              public void actionPerformed(ActionEvent event) {
                flowLayout.setAlignment(FlowLayout.CENTER);
                flowLayout.layoutContainer(container);
              }
            }
    );

    rightButton = new JButton("Right");
    add(rightButton);
    rightButton.addActionListener(
            new ActionListener() {

              public void actionPerformed(ActionEvent event) {
                flowLayout.setAlignment(FlowLayout.RIGHT);
                flowLayout.layoutContainer(container);
              }
            }
    );

  }


}
