package com.clouway.designpatterns.proxy;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class UserRegister {
  private User user;

  public void registerUser(User user){
     this.user = user;
  }

  public User getUser(){
    return user;
  }
}
