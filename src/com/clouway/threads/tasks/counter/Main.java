package com.clouway.threads.tasks.counter;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    Thread thread = new Thread(new Counter(5), "myThread");
    thread.start();
    System.out.println("Enter character to stop counting.");
    Scanner scanner = new Scanner(System.in);
    if (scanner.next().charAt(0) != 0) {
      thread.interrupt();
    }
  }
}
