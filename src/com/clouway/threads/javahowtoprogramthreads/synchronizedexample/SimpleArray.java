package com.clouway.threads.javahowtoprogramthreads.synchronizedexample;

import java.util.Random;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SimpleArray {
  private final int[] array;
  private  int writeIndex = 0;
  private final Random random = new Random();

  public SimpleArray(int size) {
    array = new int[size];
  }

  public synchronized void add(int value) {
    int position = writeIndex;
    try {
      Thread.sleep(random.nextInt(500));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    array[position] = value;
    System.out.printf( "%s wrote %2d to element %d.\n",Thread.currentThread().getName(), value, position );
    ++writeIndex;
    System.out.println("next index: "+writeIndex);
  }

  public String toString(){
    String strArray = "Content of the array: ";
    for (int i = 0; i < array.length; i++) {
      strArray += array[i] + " ";
    }
    return strArray;
  }
}
