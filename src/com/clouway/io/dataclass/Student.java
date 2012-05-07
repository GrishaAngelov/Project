package com.clouway.io.dataclass;

import java.io.Serializable;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Student implements Serializable {
  private String name;
  private int age;

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}
