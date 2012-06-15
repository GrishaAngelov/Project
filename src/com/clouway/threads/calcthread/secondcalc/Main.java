package com.clouway.threads.calcthread.secondcalc;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    Calc calc = new Calc();

    AddingThread addingThread = new AddingThread(calc, 5, 3);                // 5 + 3 = 8
    SubtractingThread subtractingThread = new SubtractingThread(calc, 5, 3); // 8 + 2 = 10

    Thread fistThread = new Thread(addingThread);
    Thread secondThread = new Thread(subtractingThread);

    fistThread.start();
    secondThread.start();
  }
}
