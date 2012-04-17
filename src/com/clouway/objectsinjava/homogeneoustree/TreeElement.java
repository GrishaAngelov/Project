package com.clouway.objectsinjava.homogeneoustree;
/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TreeElement {
  /**
   * Class TreeElement represents a single node from the tree
   */
  private TreeElement leftElement;
  private TreeElement rightElement;
  private int nodeData;

  /**
   * constructor with parameter that initialize node
   *
   * @param data - contains a node value
   */
  public TreeElement(int data) {
    nodeData = data;
    leftElement = null;
    rightElement = null;
  }

  /**
   * return left element of node
   *
   * @return left element
   */
  public TreeElement getLeftElement() {
    return leftElement;
  }

  /**
   * return right element of node
   *
   * @return right element
   */
  public TreeElement getRightElement() {
    return rightElement;
  }

  /**
   * return node value
   *
   * @return value of node
   */
  public int getNodeData() {
    return nodeData;
  }

  /**
   * inserts an node with desired value
   *
   * @param nodeValue - value for node
   */
  public void insertValue(int nodeValue) {
    if (nodeValue != nodeData) {
      if (nodeValue < nodeData) {
        if (leftElement == null) {
          leftElement = new TreeElement(nodeValue);
        } else {
          leftElement.insertValue(nodeValue);
        }
      } else {
        if (rightElement == null) {
          rightElement = new TreeElement(nodeValue);
        } else {
          rightElement.insertValue(nodeValue);
        }
      }
    }
  }

  /**
   * searching the tree to find a node with desired value
   * @param value - node value
   * @return   boolean variable that indicates whether the item is found
   */
  public boolean search(int value) {
    if (value == nodeData) {
      return true;
    } else if (value < nodeData) {
      if (leftElement == null) {
        return false;
      } else {
        return leftElement.search(value);
      }
    } else if (value > nodeData) {
      if (rightElement == null) {
        return false;
      } else {
        return rightElement.search(value);
      }
    }
    return false;
  }
}