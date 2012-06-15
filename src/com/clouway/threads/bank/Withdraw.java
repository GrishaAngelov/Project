package com.clouway.threads.bank;

import java.math.BigDecimal;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Withdraw implements Runnable {
  private Account account;
  private BigDecimal amount;

  public Withdraw(Account account, BigDecimal newAmount){
    this.account = account;
    this.amount = newAmount;
  }

  public void run(){
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
    account.withdraw(amount);
    System.out.println("amount after withdraw: "+account.getAmount());
  }
}
