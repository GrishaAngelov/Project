package com.clouway.threads.bank;

import java.math.BigDecimal;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Deposit implements Runnable{
  private Account account;
  private BigDecimal amount;

  public Deposit(Account account, BigDecimal newAmount){
    this.account = account;
    this.amount = newAmount;
  }

  public void run(){
    account.deposit(amount);
    System.out.println("amount after deposit: "+account.getAmount());
  }
}
