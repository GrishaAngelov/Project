package com.clouway.threads.pizzaservice;

import java.util.Random;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class PizzaService {
  private int currentPizzaNumber = 0;
  private Random random = new Random();

  public synchronized void makePizza() throws InterruptedException {

    while (true) {
      notify();

      currentPizzaNumber = random.nextInt(20);
      System.out.println("\nmaking pizza....");
      System.out.printf("Pizza counter: %d\n", currentPizzaNumber);
      wait();
    }
  }

  public synchronized void consumePizza() throws InterruptedException {

    while (true) {
      notify();

      System.out.println("\nclient is eating " + currentPizzaNumber + " pizzas");
      currentPizzaNumber -= currentPizzaNumber;
      System.out.printf("current pizzas: %d\n", currentPizzaNumber);
      wait();
    }
  }
}


