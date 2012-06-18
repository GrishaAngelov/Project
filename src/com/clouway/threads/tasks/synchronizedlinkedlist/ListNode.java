package com.clouway.threads.tasks.synchronizedlinkedlist;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ListNode {

  Object data;
  ListNode next;

  /**
   * Constructor that initializes the node
   *
   * @param data - node data
   */
  public ListNode(Object data) {
    this.data = data;
    next = null;
  }

  /**
   * Returns the data contained in the node
   *
   * @return data - contained value of the node
   */
  public Object getData() {
    return data;
  }

  /**
   * Returns reference to the next node in the linked list
   *
   * @return next - reference to the next node
   */
  public ListNode getNext() {
    return next;
  }
}