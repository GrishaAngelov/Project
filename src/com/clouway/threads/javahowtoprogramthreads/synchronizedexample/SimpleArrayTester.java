package com.clouway.threads.javahowtoprogramthreads.synchronizedexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SimpleArrayTester {
  public static void main(String[] args) {
    SimpleArray sharedArray = new SimpleArray(6);
    ArrayWriter writer1 = new ArrayWriter(sharedArray, 1);
    ArrayWriter writer2 = new ArrayWriter(sharedArray,11);
    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.execute(writer1);
    executorService.execute(writer2);
    executorService.shutdown();
    try
    {
     // wait 1 minute for both writers to finish executing
      boolean tasksEnded = executorService.awaitTermination(1, TimeUnit.MINUTES );
      if ( tasksEnded )
        System.out.println( sharedArray );
      else
      System.out.println(
              "Timed out while waiting for tasks to finish." );
       }
     catch ( InterruptedException ex )
     {
       System.out.println(
               "Interrupted while wait for tasks to finish." );
       }
  }
}
