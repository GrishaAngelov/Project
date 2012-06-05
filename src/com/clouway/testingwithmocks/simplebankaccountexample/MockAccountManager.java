package com.clouway.testingwithmocks.simplebankaccountexample;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MockAccountManager implements AccountManager {

  private Hashtable accounts = new Hashtable<Integer, Account>();

  public void addAccount(Account account) {
    accounts.put(account.getAccountID(), account);
  }

  public Account findAccountById(int id) {
    return (Account) accounts.get(id);
  }
}
