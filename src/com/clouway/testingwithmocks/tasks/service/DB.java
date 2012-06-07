package com.clouway.testingwithmocks.tasks.service;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface DB {
  String addPerson(String name, String age);

  String getPersonAge(String name);
}
