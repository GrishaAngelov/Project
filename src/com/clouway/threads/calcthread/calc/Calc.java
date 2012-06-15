package com.clouway.threads.calcthread.calc;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Calc {

  private int result = 0;

  public synchronized int add(int fNum, int sNum) {
    result = result + (fNum + sNum);
    return result;
  }

  public synchronized int sub(int fNum, int sNum) {
    result = result + (fNum - sNum);
    return result;
  }
}
