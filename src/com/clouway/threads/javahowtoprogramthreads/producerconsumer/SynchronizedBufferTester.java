package com.clouway.threads.javahowtoprogramthreads.producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SynchronizedBufferTester {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    Buffer sharedBuffer = new SynchronizedBuffer();
    executorService.execute(new Producer(sharedBuffer));
    executorService.execute(new Consumer(sharedBuffer));
    executorService.shutdown();
  }
}
