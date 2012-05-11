package com.clouway.collections.messagemanager;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {

  public static void main(String[] args) {
    ExceptionsMessageManager manager = new ExceptionsMessageManager();
    try {
     // manager.registerErrorMessage("1", "Incorrect PIN!");
      manager.registerErrorMessage("4", "Incorrect address!");

      System.out.println("1: " + manager.raiseError("1"));
      //System.out.println("10: " + manager.raiseError("10"));

      System.out.println("\nall error messages:");
      System.out.println(manager.getErrorMessages());

    } catch (DuplicateCombinationException e) {
      System.out.println(e.getMessage());
    } catch (KeyNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }
}
