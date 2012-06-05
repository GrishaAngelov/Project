package com.clouway.testingwithmocks.simplebankaccountexample;

import java.math.BigDecimal;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class AccountService {

  private AccountManager accountManager;

  public AccountService(AccountManager accountManager) {
    this.accountManager = accountManager;
  }

  public void transfer(int senderID, int receiverID, BigDecimal amount) {
    Account sender = accountManager.findAccountById(senderID);
    Account receiver = accountManager.findAccountById(receiverID);

    sender.withdrawSum(amount);
    receiver.depositSum(amount);
  }
}
