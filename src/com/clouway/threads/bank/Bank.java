package com.clouway.threads.bank;

import java.math.BigDecimal;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Bank {
  public static void main(String[] args) {
    final Account account = new Account();

//    Thread depositThread = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        account.deposit(new BigDecimal("100"));
//        System.out.println("amount after deposit: "+account.getAmount());
//      }
//    });
//
//    Thread withdrawThread = new Thread(new Runnable() {
//      @Override
//      public void run() {
//        try {
//          Thread.sleep(100);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
//        account.withdraw(new BigDecimal("20"));
//        System.out.println("amount after withdraw: "+account.getAmount());
//      }
//    });
//
//    depositThread.start();
//    withdrawThread.start();

    Deposit deposit = new Deposit(account,new BigDecimal("100"));
    Withdraw withdraw = new Withdraw(account, new BigDecimal("20"));

    Thread depositThread = new Thread(deposit);
    Thread withdrawThread = new Thread(withdraw);

    depositThread.start();
    withdrawThread.start();

  }
}
