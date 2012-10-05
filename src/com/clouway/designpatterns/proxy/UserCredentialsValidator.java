package com.clouway.designpatterns.proxy;

import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class UserCredentialsValidator implements CredentialsValidator {
  private UserRegister userRegister;

  public UserCredentialsValidator(UserRegister userRegister) {
    this.userRegister = userRegister;
  }

  @Override
  public boolean validate(User user) {
    boolean isValid = false;
    List<User> usersList = userRegister.getUserList();
    for (User userFromList : usersList) {
      if (user.getUserName() == userFromList.getUserName() && user.getPassword() == userFromList.getPassword()) {
        isValid = true;
        break;
      }
    }

    return isValid;
  }
}
