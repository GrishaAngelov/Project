package com.clouway.threads.calcthread.secondcalc;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class AddingThread implements Runnable {
  private Calc calc;
  private int fNum, sNum;

  public AddingThread(Calc calc, int fNum, int sNum) {
    this.calc = calc;
    this.fNum = fNum;
    this.sNum = sNum;
  }

  public void run() {
    System.out.println(calc.add(fNum, sNum));
  }
}
