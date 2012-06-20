package com.clouway.threads.randomelementgetter;

import java.util.Random;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ElementOperator {
  private int[] myArray;
  private Random random = new Random();

  public ElementOperator(int size) {
    myArray = new int[size];
  }

  public synchronized void fillElements() throws InterruptedException {
    while (true) {
      notify();
      System.out.println();
      for (int i = 0; i < myArray.length; i++) {
        int element = random.nextInt(101);
        System.out.println("add: " + element);
        myArray[i] = element;
      }
      wait();
    }
  }

  public synchronized void getElements() throws InterruptedException {
    while (true) {
      notify();
      int size = random.nextInt(myArray.length + 1);
      System.out.printf("take %d elements\n", size);
      for (int i = 0; i < size; i++) {
        System.out.println("element" + i + " = " + myArray[i]);
      }
      wait();
    }
  }
}
