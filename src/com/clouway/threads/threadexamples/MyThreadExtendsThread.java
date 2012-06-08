package com.clouway.threads.threadexamples;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MyThreadExtendsThread extends Thread {
  public void run(){
    System.out.println("this is run()...");
  }

  public static void main(String[] args) {
    Thread myThread = new MyThreadExtendsThread();
    myThread.start();
  }
}
