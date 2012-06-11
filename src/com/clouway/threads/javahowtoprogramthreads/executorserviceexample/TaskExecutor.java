package com.clouway.threads.javahowtoprogramthreads.executorserviceexample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TaskExecutor {
  public static void main(String[] args) {
    PrintTask task1 = new PrintTask("firstTask");
    PrintTask task2 = new PrintTask("secondTask");
    PrintTask task3 = new PrintTask("thirdTask");

    ExecutorService threadExecutor = Executors.newCachedThreadPool();
    threadExecutor.execute(task1);
    threadExecutor.execute(task2);
    threadExecutor.execute(task3);
    //notifies the ExecutorService to stop accepting new tasks, but continues executing tasks that have already been submitted.
    threadExecutor.shutdown();
  }
}
