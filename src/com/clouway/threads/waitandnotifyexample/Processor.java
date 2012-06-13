package com.clouway.threads.waitandnotifyexample;

import java.util.Scanner;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Processor {
  public void produce() throws InterruptedException{
    synchronized (this){
      System.out.println("Producer thread running ...");
      wait();
      System.out.println("Resumed");
    }
  }
  public void consume() throws InterruptedException{
    Scanner scanner = new Scanner(System.in);
    Thread.sleep(200);
    synchronized (this){
      System.out.println("Press any key");
      scanner.nextLine();
      System.out.println("Key pressed");
      notify();
    }
  }
}
