package com.clouway.objectsinjava.homogeneoustree;
/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

public class Tree {
  /**
   * Class Tree builds a binary search tree
   */
  private TreeElement root;

  public Tree() {
    root = null;
  }

  /**
   * inserts node with concrete value
   *
   * @param value - contain value
   */
  public void insertNode(int value) {
    if (root == null) {
      root = new TreeElement(value);
    } else {
      root.insertValue(value);
    }
  }

  /**
   * searching tree to find a node with desired value
   *
   * @param value - contain value
   * @return boolean variable that indicates whether the node is found
   */
  public boolean searchElement(int value) {

    if (root == null) {
      return false;
    } else {

      return root.search(value);
    }

  }

  /**
   * prints whole tree by calling print(TreeElement root) method
   */
  public void printTree() {
    print(root);
  }

  /**
   * printig whole tree starting from root
   *
   * @param root - root of the tree
   */
  private void print(TreeElement root) {

    if (root == null) {
      return;
    }
    print(root.getLeftElement());
    System.out.printf("%d ", root.getNodeData());
    print(root.getRightElement());
  }
}