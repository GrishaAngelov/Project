package com.clouway.threads.randomelementgetter;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    final ElementOperator elementOperator = new ElementOperator(5);

    Thread fillingThread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          elementOperator.fillElements();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread gettingThread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          elementOperator.getElements();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    fillingThread.start();
    gettingThread.start();
  }
}
