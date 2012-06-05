package com.clouway.testingwithmocks.simplebankaccountexample;

import java.math.BigDecimal;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Account {
  private int accountID;
  private BigDecimal balance;

  public Account(int accountID, BigDecimal balance) {
    this.accountID = accountID;
    this.balance = balance;
  }

  public void depositSum(BigDecimal amount) {
    balance = balance.add(amount);
  }

  public void withdrawSum(BigDecimal amount) {
    balance = balance.subtract(amount);
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public int getAccountID() {
    return accountID;
  }
}
