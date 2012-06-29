package com.clouway.gui.tables.sortingcolumn;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ColumnExample extends JFrame {
  public ColumnExample() {
    super("JTable Test");
    setSize(300, 200);
    DefaultTableModel dtm = new DefaultTableModel(
            new String[][]{
                    {"1", "2", "3"},
                    {"4", "5", "6"}
            },
            new String[]{"Balls", "Apples", "Dogs"}
    );
    SortingColumnModel scm = new SortingColumnModel();
    JTable table = new JTable(dtm, scm);
    table.createDefaultColumnsFromModel();
    JScrollPane pane = new JScrollPane(table);
    getContentPane().add(pane, BorderLayout.CENTER);
  }

  public static void main(String args[]) {
    ColumnExample columnExample = new ColumnExample();
    columnExample.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    columnExample.setVisible(true);
  }
}