package com.clouway.threads.javahowtoprogramthreads.producerconsumer;

import java.util.Random;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Producer implements Runnable {
  private final Random random = new Random();
  private final Buffer sharedBuffer;

  public Producer(Buffer sharedBuffer) {
    this.sharedBuffer = sharedBuffer;
  }

  public void run() {
    int sum = 0;
    for (int i = 1; i <= 5; i++) {
      try {
        Thread.sleep(random.nextInt(300));
        sharedBuffer.set(i);
        sum += i;
        System.out.println("sum of produced: "+sum);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
