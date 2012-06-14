package com.clouway.threads.bankexample;

import java.math.BigDecimal;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Bank {
  public static void main(String[] args) {
    Account account = new Account(new BigDecimal("100"));

    Depositor service1 = new Depositor(account,new BigDecimal("20"));
    Depositor service2 = new Depositor(account,new BigDecimal("50"));

    Thread thread1 = new Thread(service1);
    Thread thread2 = new Thread(service2);

    thread1.start();
    thread2.start();

  }
}
