package com.clouway.exceptions.linkedlist;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

public class Main {
  
  static class ConsoleDisplay implements Display {

    @Override
    public void write(String message) {
      System.out.println(message);
    }
  }
  
  public static void main(String[] args) {
    try {
    LinkedList list = new LinkedList(3);
//    list.add(new Integer(5));
//    list.add(new String("str"));
//    list.add(new Integer(6));
//    list.printAllElements();
    list.add(new Integer(5));
//    list.remove();
      
      ConsoleDisplay display = new ConsoleDisplay();
    list.printAllElements(display);

//      linkedlist list = new linkedlist(1);
//      list.remove();

    } catch (EmptyListException elre) {
      System.out.print(elre.getMessage());
    } catch (FullListException fle) {
      System.out.print(fle.getMessage());
    }
  }
}