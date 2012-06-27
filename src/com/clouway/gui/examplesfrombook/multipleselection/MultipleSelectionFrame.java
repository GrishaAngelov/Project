package com.clouway.gui.examplesfrombook.multipleselection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MultipleSelectionFrame extends JFrame {
  private JList colorList;
  private JList copyList;
  private JButton copyButton;
  private String[] colorNames = {"Blue","Green","Red","Yellow","Orange"};

  public MultipleSelectionFrame(){
    super("Multiple selection");
    setLayout(new FlowLayout());

    colorList = new JList(colorNames);
    colorList.setVisibleRowCount(3);
    colorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    colorList.setFixedCellHeight(20);
    colorList.setFixedCellWidth(100);
    add(new JScrollPane(colorList));

    copyButton = new JButton("Copy >>>");
    copyButton.addActionListener(
            new ActionListener() {

              public void actionPerformed(ActionEvent event) {
                copyList.setListData(colorList.getSelectedValues());
              }
            }
    );

    add(copyButton);
    copyList = new JList();
    copyList.setVisibleRowCount(3);
    copyList.setFixedCellHeight(20);
    copyList.setFixedCellWidth(100);
    copyList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    add(new JScrollPane(copyList));
  }
}
