package com.clouway.objectsinjava.heterogenioustree;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TreeElement {
  private TreeElement leftElement;
  private TreeElement rightElement;
  private int key;
  private Object data;

  public TreeElement(int key, Object data) {
    this.key = key;
    this.data = data;
    leftElement = null;
    rightElement = null;
  }

  public TreeElement getLeftElement() {
    return leftElement;
  }

  public TreeElement getRightElement() {
    return rightElement;
  }

  public Object getObject() {
    return data;
  }

  public int getKey() {
    return key;
  }

  public void insertValue(int key, Object object) {
    if (key != this.key) {
      if (key < this.key) {
        if (leftElement == null) {
          leftElement = new TreeElement(key, object);
        } else {
          leftElement.insertValue(key, object);
        }
      } else {
        if (rightElement == null) {
          rightElement = new TreeElement(key, object);
        } else {
          rightElement.insertValue(key, object);
        }
      }
    }
  }
}