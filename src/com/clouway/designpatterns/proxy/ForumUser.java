package com.clouway.designpatterns.proxy;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ForumUser implements User {
  private String userName;
  private String password;

  public ForumUser(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  @Override
  public String getUserName() {
    return userName;
  }

  @Override
  public String getPassword() {
    return password;
  }
}
