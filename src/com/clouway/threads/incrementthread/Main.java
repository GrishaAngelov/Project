package com.clouway.threads.incrementthread;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    ThreadIncrementor threadIncrementor = new ThreadIncrementor();
    threadIncrementor.action();
  }
}
