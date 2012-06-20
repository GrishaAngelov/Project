package com.clouway.threads.pizzaservice;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    final PizzaService pizzaService = new PizzaService();

    Thread pizzaProducer = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          pizzaService.makePizza();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread pizzaConsumer = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(500);
          pizzaService.consumePizza();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    pizzaProducer.start();
    pizzaConsumer.start();
  }
}
