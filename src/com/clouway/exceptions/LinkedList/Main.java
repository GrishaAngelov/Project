package com.clouway.exceptions.LinkedList;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

public class Main {
  public static void main(String[] args) {
    try {
    LinkedList list = new LinkedList(3);
//    list.add(new Integer(5));
//    list.add(new String("str"));
//    list.add(new Integer(6));
//    list.printAllElements();
//    list.add(new Integer(5));
//    list.remove();
    list.printAllElements();

//      LinkedList list = new LinkedList(1);
//      list.remove();

    } catch (EmptyListRemoveException elre) {
      System.out.print(elre.getMessage());
    } catch (FullListException fle) {
      System.out.print(fle.getMessage());
    }
  }
}