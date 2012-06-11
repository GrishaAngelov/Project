package com.clouway.threads.javahowtoprogramthreads.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class BlockingBuffer implements Buffer {
  private final ArrayBlockingQueue<Integer> buffer;

  public BlockingBuffer() {
    buffer = new ArrayBlockingQueue<Integer>(1);
  }

  public void set(int value) throws InterruptedException {
    buffer.put(value);
    System.out.printf("%s%2d\t%s%d\n", "Producer writes ", value, "Buffer cells occupied: ", buffer.size());
  }

  public int get() throws InterruptedException {
    int readValue = 0;
    readValue = buffer.take();
    System.out.printf("%s%2d\t%s%d\n", "Consumer reads ", readValue, "Buffer cells occupied: ", buffer.size());
    return readValue;
  }
}
