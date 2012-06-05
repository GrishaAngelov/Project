package com.clouway.testingwithmocks.simplebankaccountexample;

import java.math.BigDecimal;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface AccountManager {
  Account findAccountById(int id);
}
