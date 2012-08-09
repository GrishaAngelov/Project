package com.clouway.gui.calculatortask;

import java.util.Hashtable;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Operator {
  private AddOperation addOperation = new AddOperation();
  private SubtractOperation subtractOperation = new SubtractOperation();
  private MultiplyOperation multiplyOperation = new MultiplyOperation();
  private DivideOperation divideOperation = new DivideOperation();
  private Hashtable<String, Operation> table = new Hashtable<String, Operation>();

  public Hashtable<String, Operation> fill() {
    table.put("+", addOperation);
    table.put("-", subtractOperation);
    table.put("*", multiplyOperation);
    table.put("/", divideOperation);
    return table;
  }
}
