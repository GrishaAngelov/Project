package com.clouway.threads.javahowtoprogramthreads.producerconsumer;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SynchronizedBuffer implements Buffer {
  private int buffer = -1;
  private boolean occupied = false;

  public void displayState(String operation) {
    System.out.printf("%-40s%d\t\toccupied:%b\n", operation, buffer, occupied);
  }

  public synchronized void set(int value) throws InterruptedException {
    // while there are no empty locations, place thread in waiting state
    while (occupied) {
      System.out.println("Producer tries to write.");
      displayState("Buffer full. Producer waits.");
      wait();
    }
    buffer = value;
    // indicate producer cannot store another value
    // until consumer retrieves current buffer value
    occupied = true;
    displayState("Producer writes " + buffer);
    notifyAll();
  }


  public synchronized int get() throws InterruptedException {
    // while no data to read, place thread in waiting state
    while (!occupied){
      System.out.println("Consumer tries to read.");
      displayState("Buffer empty.Consumer waits.");
      wait();
    }
    // indicate that producer can store another value
    // because consumer just retrieved buffer value
    occupied = false;
    displayState("Consumer reads "+buffer);
    notifyAll();
    return buffer;
  }
}


