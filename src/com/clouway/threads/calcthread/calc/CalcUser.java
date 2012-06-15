package com.clouway.threads.calcthread.calc;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class CalcUser {
  public static void main(String[] args) {

    final Calc calc = new Calc();

    Thread firstThread = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println(calc.add(5, 3));     // 5 + 3 = 8
      }
    });

    Thread secondThread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.currentThread().sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(calc.sub(5, 3));     // 8 + 2 = 10
      }
    });

    firstThread.start();
    secondThread.start();
  }
}
