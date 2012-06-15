package com.clouway.threads.bank;

import java.math.BigDecimal;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Account {
  private BigDecimal amount = new BigDecimal("0");

  public synchronized void deposit(BigDecimal amountValue){
    amount = amount.add(amountValue);
  }

  public synchronized void withdraw(BigDecimal amountValue) {
    amount = amount.subtract(amountValue);
  }

  public BigDecimal getAmount(){
    return amount;
  }
}
