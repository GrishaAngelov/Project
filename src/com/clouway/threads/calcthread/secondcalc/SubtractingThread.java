package com.clouway.threads.calcthread.secondcalc;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SubtractingThread implements Runnable {
  private Calc calc;
  private int fNum, sNum;

  public SubtractingThread(Calc calc, int fNum, int sNum) {
    this.calc = calc;
    this.fNum = fNum;
    this.sNum = sNum;
  }

  public void run() {
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(calc.sub(fNum, sNum));
  }

}
