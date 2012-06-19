package com.clouway.threads.tasks.synchronizedlinkedlist;

import java.util.Random;
import java.util.Scanner;

/**
 * @author  Grisha Angelov <grisha.angelov@clouway.com>
 */
public class LinkedList {

  private ListNode firstNode;
  private ListNode lastNode;
  private int sizeList = 0;
  private int counter = 0;
  private Random random = new Random();

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
  private boolean isEmpty() {
    return firstNode == null;
  }

  /**
   * Checks whether linked list is full
   */
  public synchronized void isFull() throws InterruptedException {
    if (counter > sizeList) {
      System.out.println("list is full... removing last element");
      wait(500);
    }
  }

  /**
   * Adds a new node at the end of linked list
   *
   * @param element - node which will be added at the end of the linked list
   */
  public synchronized void add(Object element) throws InterruptedException {

    isFull();
    if (isEmpty()) // firstNode and lastNode refer to same Object
    {

      firstNode = lastNode = new ListNode(element);
      System.out.println("added: " + element);
    } else // lastNode's nextNode refers to new node
    {
      lastNode = lastNode.next = new ListNode(element);
      System.out.println("added: " + element);
    }
    counter++;
    notify();
  }

  /**
   * Removes last node of the linked list
   */
  public synchronized void remove() throws InterruptedException {
    if (isEmpty()) {
      add(random.nextInt());
      notify();
    }
    Object removedItem = lastNode.getData();
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
    notify();
  }

  /**
   * Prints all elements (nodes) in the linked list
   */
  public synchronized void printAllElements(Display display) {
    ListNode current = firstNode;
    while (current != null) {
      display.write(String.format("%s\n", current.getData()));
      current = current.next;
    }
  }
}