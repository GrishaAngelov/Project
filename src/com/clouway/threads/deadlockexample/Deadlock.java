package com.clouway.threads.deadlockexample;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Deadlock {

  public static void main(String[] args) {
    final Object object1 = new Object();
    final Object object2 = new Object();

    Thread firstThread = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (object1) {
          System.out.println("first thread: object1 is locked");
          System.out.println("first thread is sleeping...");
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("first thread is waked...");
          System.out.println("first thread: waiting for object2...");
          synchronized (object2){
            System.out.println("first thread: object2 is locked");
          }
        }
      }
    });

    Thread secondThread = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (object2){
          System.out.println("second thread: object2 is locked");
          System.out.println("second thread is sleeping...");
          try {
            Thread.sleep(1000);
          } catch (Exception e) {
          }
          System.out.println("second thread is waked...");
          System.out.println("second thread: waiting for object1...");
          synchronized (object1){
            System.out.println("second thread: object1 is locked");
          }
        }
      }
    });

    firstThread.start();
    secondThread.start();
  }
}
