package com.clouway.objectsinjava.homogeneoustree;
/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Tree tree = new Tree();
    int value;
    int size;
    System.out.print("number of nodes: ");
    Scanner scanner = new Scanner(System.in);
    size = Integer.parseInt(scanner.nextLine());
    if (size < 0) {
      System.out.println("Incorrect input!");
    }
    for (int i = 1; i <= size; i++) {
      System.out.printf("Enter nodeValue %d: ", i);
      value = Integer.parseInt(scanner.nextLine());
      tree.insertNode(value);
    }
    tree.printTree();
    tree.insertNode(100);
    tree.insertNode(100);
    System.out.println();
    tree.printTree();
    System.out.println();
    System.out.println("found element: " + tree.searchElement(100));

  }
}