package com.clouway.collections.pagebean;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<Integer>();

    list.add(1);
    list.add(2);

    list.add(3);
    list.add(4);

    list.add(5);
    list.add(6);

    list.add(7);
    //list.add(8);

    int pageSize = 3;
    PageBean pageBean = new PageBean(list, pageSize);
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter\n\"n\" for next page\n\"p\" for previous page\n\"f\" for first page\n\"l\" for last page\nTo quit enter \"q\".\n");
    System.out.println(pageBean.next());
    System.out.println("Current Page: " + pageBean.getCurrentPageNumber());

    System.out.print("Enter command: ");
    String input = scanner.nextLine();
    try {
      while (!(input.equals("q"))) {
        if (input.equals("n")) {
          try {
            System.out.println(pageBean.next());
            System.out.println("Current Page: " + pageBean.getCurrentPageNumber());
          } catch (OutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Current Page: " + pageBean.getCurrentPageNumber());
          }
        } else if (input.equals("p")) {
          try {
            System.out.println(pageBean.previous());
            System.out.println("Current Page: " + pageBean.getCurrentPageNumber());
          } catch (OutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Current Page: " + pageBean.getCurrentPageNumber());
          }
        } else if (input.equals("f")) {
          try {
            System.out.println(pageBean.firstPage());
            System.out.println("Current Page: " + pageBean.getCurrentPageNumber());
          } catch (OutOfBoundsException e) {
            System.out.println(e.getMessage());
          }
        } else if (input.equals("l")) {
          try {
            System.out.println(pageBean.lastPage());
            System.out.println("Current Page: " + pageBean.getCurrentPageNumber());
          } catch (OutOfBoundsException e) {
            System.out.println(e.getMessage());
          }
        } else {
          System.out.println("Incorrect input!");
        }
        System.out.print("Enter command: ");
        input = scanner.next();
      }
    } finally {
      scanner.close();
    }
  }
}
