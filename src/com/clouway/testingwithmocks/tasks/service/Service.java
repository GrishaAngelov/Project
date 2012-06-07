package com.clouway.testingwithmocks.tasks.service;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Service {
  private DB db;

  public Service(DB db) {
    this.db = db;
  }

  public void addPerson(String name, String personAge) {
    int age = Integer.parseInt(personAge);
    if (age < 10 || age > 100) {
      throw new IncorrectAgeValueException();
    } else {
      db.addPerson(name, personAge);
    }
  }

  public boolean getPersonAge(String name) {
    int age = Integer.parseInt(db.getPersonAge(name));
    if (age < 18) {
      return false;
    } else {
      return true;
    }
  }
}
