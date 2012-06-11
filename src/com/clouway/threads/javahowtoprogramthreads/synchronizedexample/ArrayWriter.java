package com.clouway.threads.javahowtoprogramthreads.synchronizedexample;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ArrayWriter implements Runnable {
  private final SimpleArray sharedArray;
  private final int startValue;

  public ArrayWriter(SimpleArray sharedArray, int startValue){
    this.sharedArray = sharedArray;
    this.startValue = startValue;
  }

  public void run(){
    for (int i = startValue; i < startValue+3 ; i++) {
      sharedArray.add(i);
    }
  }
}
