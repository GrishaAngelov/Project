package com.clouway.threads.tasks.synchronizedlinkedlist;

/**
 * @author  Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {

  public static void main(String[] args) {

    int listSize = 2;
    LinkedList list = new LinkedList(listSize);
    ConsoleDisplay consoleDisplay = new ConsoleDisplay();

    AddingThread addingThread1 = new AddingThread(list, consoleDisplay, 5);
    AddingThread addingThread2 = new AddingThread(list, consoleDisplay, 3);
    AddingThread addingThread3 = new AddingThread(list, consoleDisplay, "str");
    RemovingThread removingThread1 = new RemovingThread(list);

    Thread firstAddingThread = new Thread(addingThread1);
    Thread secondAddingThread = new Thread(addingThread2);
    Thread thirdAddingThread = new Thread(addingThread3);
    Thread removingThread = new Thread(removingThread1);

    System.out.println("List size: " + listSize);

    firstAddingThread.start();
    secondAddingThread.start();
    thirdAddingThread.start();
    removingThread.start();
  }
}
