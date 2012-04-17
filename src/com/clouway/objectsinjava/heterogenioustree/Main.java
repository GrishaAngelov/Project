package com.clouway.objectsinjava.heterogenioustree;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

public class Main {
  public static void main(String[] args) {

    Tree tree = new Tree();
    Dog myDog = new Dog("fox terrier");
    Integer myInt = new Integer(2);
    tree.insertNode(5, myDog);
    tree.insertNode(1, myDog);
    tree.insertNode(9, myDog);
    tree.insertNode(9, myDog);
    tree.insertNode(10, myInt);
    tree.printElement();
  }
}