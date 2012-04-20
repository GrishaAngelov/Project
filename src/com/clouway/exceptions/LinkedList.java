package com.clouway.exceptions;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class LinkedList {

  private ListNode firstNode;
  private ListNode lastNode;
  private int sizeList = 0;
  private int counter = 0;

  /**
   * Constructor that creates empty linked list with fixed size
   *
   * @param size - size of linked list
   */
  public LinkedList(int size) {
    firstNode = lastNode = null;
    sizeList = size;
    counter = 1;
  }

  /**
   * Checks whether linked list empty
   *
   * @return 'true' if linked list is empty or 'false' if it isn't empty
   */
  public boolean isEmpty() {
    return firstNode == null;
  }

  /**
   * Checks whether linked list is full
   *
   * @throws FullListException if linked list is full
   */
  public void isFull() throws FullListException {
    if (counter > sizeList) {
      throw new FullListException();
    }
  }

  /**
   * Adds a new node at the end of linked list
   *
   * @param element - node which will be added at the end of the linked list
   * @throws FullListException if linked list is full
   */
  public void add(Object element) throws FullListException {

    isFull();
    if (isEmpty()) // firstNode and lastNode refer to same Object
    {
      firstNode = lastNode = new ListNode(element);
    } else // lastNode's nextNode refers to new node
    {
      lastNode = lastNode.next = new ListNode(element);
    }
    counter++;
  }

  /**
   * Removes last node of the linked list
   *
   * @throws EmptyListException if the list is empty
   */
  public void remove() throws EmptyListException {
    if (isEmpty()) {
      throw new EmptyListException();
    }
    Object removedItem = lastNode.data;
    if (firstNode == lastNode) {
      firstNode = lastNode = null;
    } else {
      ListNode current = firstNode;
      while (current.getNext() != lastNode) {
        current = current.getNext();
      }
      lastNode = current;
      current.next = null;
    }
  }

  /**
   * Prints all elements (nodes) in the linked list
   */
  public void printAllElements() {
    if (isEmpty()) {
      System.out.printf("Empty list!\n");
      return;
    }
    ListNode current = firstNode;
    // while not at end of list, output current node's data
    while (current != null) {
      System.out.printf("%s\n", current.data);
      current = current.next;
    }
    System.out.println();
  }
}