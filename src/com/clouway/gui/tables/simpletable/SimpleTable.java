package com.clouway.gui.tables.simpletable;

import javax.swing.*;
import java.awt.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SimpleTable extends JFrame {
  public SimpleTable() {
    super("Simple JTable");
    setSize(300, 200);
    JTable table = new JTable(
            new String[][]{{"This", "is"}, {"a", "Test"}},
            new String[]{"Column", "Header"}
    );
    JScrollPane pane = new JScrollPane(table);
    getContentPane().add(pane, BorderLayout.CENTER);
  }

  public static void main(String args[]) {
    SimpleTable simpleTable = new SimpleTable();
    simpleTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    simpleTable.setVisible(true);
  }
}
