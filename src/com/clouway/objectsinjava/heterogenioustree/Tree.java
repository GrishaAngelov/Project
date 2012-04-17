package com.clouway.objectsinjava.heterogenioustree;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Tree {


  private TreeElement root;


  public Tree() {
    root = null;
  }

  public void insertNode(int value, Object data) {
    if (root == null) {
      root = new TreeElement(value, data);
    } else {
      root.insertValue(value, data);
    }
  }

  public void printElement() {
    print(root);
  }

  private void print(TreeElement root) {

    if (root == null) {
      return;
    }
    print(root.getLeftElement());
    System.out.println(root.getKey() + ", " + root.getObject());
    print(root.getRightElement());
  }
}