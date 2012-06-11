package com.clouway.threads.javahowtoprogramthreads.producerconsumer;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface Buffer {
  public void set(int value) throws InterruptedException;

  public int get() throws InterruptedException;
}
