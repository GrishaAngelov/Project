package com.clouway.threads.threadexamples;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class InterruptThread implements Runnable {
  public void run() {
    try{
      Thread.currentThread().sleep(1000);
      System.out.println("this is run()... " + Thread.currentThread().getName());
    }catch (InterruptedException e){

      System.out.println(Thread.currentThread().getName()+" is interrupted");
      doSomething();
    }
  }

  public void doSomething(){
    System.out.println(Thread.currentThread().getName()+" is doing something else...");
  }

  public static void main(String[] args) throws InterruptedException{
    Thread thread1 = new Thread(new TwoThreadsExample(), "firstThread ");
    Thread thread2 = new Thread(new TwoThreadsExample(), "secondThread ");

    System.out.println(thread1.getName() + "call start()");
    thread1.start();
    thread1.sleep(1000);
    thread1.interrupt();

    System.out.println(thread2.getName() + "call start()");
    thread2.start();
  }
}
