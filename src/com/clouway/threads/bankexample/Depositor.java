package com.clouway.threads.bankexample;

import java.math.BigDecimal;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Depositor implements Runnable {
  Account account;
  BigDecimal amount;


  public Depositor(Account account, BigDecimal amount) {
    this.account = account;
    this.amount = amount;
  }

  public void run() {
    synchronized (amount) {
      account.setAmount(account.getAmount().add(amount));
      System.out.println(account.getAmount());
    }
  }
}
