package com.clouway.threads.bankexample;

import java.math.BigDecimal;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Account {
  private BigDecimal amount;

  public Account(BigDecimal amount){
    this.amount = amount;
  }

  public void setAmount(BigDecimal amountValue) {
    amount = amountValue;
  }

  public BigDecimal getAmount(){
    return amount;
  }
}
