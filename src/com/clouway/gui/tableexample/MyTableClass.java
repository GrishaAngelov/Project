package com.clouway.gui.tableexample;

import javax.swing.*;
import javax.swing.table.TableColumn;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MyTableClass extends JFrame {
  private JTable table;
  private JScrollPane pane;
  private String[] columnNames = {"FirstName", "Age", "Sport"};
  private Object[][] data = {
          {"John", "21", "Swimming"},
          {"Simon", "18", "Cycling"},
          {"Peter", "21", "Swimming"},
          {"Robert", "18", "Cycling"}
  };

  public MyTableClass(){
    setTitle("simple table");
    table = new JTable(data,columnNames);
    pane = new JScrollPane(table);
    add(pane);
  }
}
