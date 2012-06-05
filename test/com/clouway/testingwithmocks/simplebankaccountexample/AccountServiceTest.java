package com.clouway.testingwithmocks.simplebankaccountexample;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class AccountServiceTest {

  private MockAccountManager mockAccountManager;
  private AccountService accountService;
  private Account account;


  @Before
  public void setUp() {
    mockAccountManager = new MockAccountManager();
    accountService = new AccountService(mockAccountManager);
    account = new Account(1235, new BigDecimal("1000"));
    mockAccountManager.addAccount(account);
  }

  // indirect test of transfer,because it consists of deposit and withdraw methods
  @Test
  public void testDepositSum(){
    account.depositSum(new BigDecimal("100"));
    assertEquals(new BigDecimal("1100"),account.getBalance());
  }

  @Test
  public void testWithdrawSum(){
    account.withdrawSum(new BigDecimal("100"));
    assertEquals(new BigDecimal("900"),account.getBalance());
  }
}
