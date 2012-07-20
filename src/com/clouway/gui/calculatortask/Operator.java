package com.clouway.gui.calculatortask;

import java.util.Hashtable;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Operator {
  private Adder adder = new Adder();
  private Subtractor subtractor = new Subtractor();
  private Multiplier multiplier = new Multiplier();
  private Divisor divisor = new Divisor();
  private Hashtable<String, Operation> table = new Hashtable<String, Operation>();

  public Hashtable<String, Operation> fill() {
    table.put("+", adder);
    table.put("-", subtractor);
    table.put("*", multiplier);
    table.put("/", divisor);
    return table;
  }
}
