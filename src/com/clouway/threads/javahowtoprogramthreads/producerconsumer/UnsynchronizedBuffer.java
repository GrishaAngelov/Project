package com.clouway.threads.javahowtoprogramthreads.producerconsumer;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class UnsynchronizedBuffer implements Buffer {
  private int buffer = -1;

  public void set(int value) {
    buffer = value;
    System.out.println("Producer writes: " + value);
  }

  public int get() {
    System.out.println("Consumer  reads: " + buffer);
    return buffer;
  }
}
