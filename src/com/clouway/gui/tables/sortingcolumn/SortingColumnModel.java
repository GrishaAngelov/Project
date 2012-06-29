package com.clouway.gui.tables.sortingcolumn;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SortingColumnModel extends DefaultTableColumnModel {
  public void addColumn(TableColumn tableColumn) {
    super.addColumn(tableColumn);
    int newIndex = sortedIndexOf(tableColumn);
    if (newIndex != tableColumn.getModelIndex()) {
      moveColumn(tableColumn.getModelIndex(), newIndex);
    }
  }

  protected int sortedIndexOf(TableColumn tableColumn) {
    int stop = getColumnCount();
    String name = tableColumn.getHeaderValue().toString();
    for (int i = 0; i < stop; i++) {
      if (name.compareTo(getColumn(i).getHeaderValue().toString()) <= 0) {
        return i;
      }
    }
    return stop;
  }
}
