package com.clouway.designpatterns.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class UserRegister {
  private List<User> userList = new ArrayList<User>();

  public void registerUser(User user) {
    userList.add(user);
  }

  public List<User> getUserList() {
    return userList;
  }
}
