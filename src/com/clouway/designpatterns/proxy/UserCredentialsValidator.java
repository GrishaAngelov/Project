package com.clouway.designpatterns.proxy;

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
    User registeredUser = userRegister.getUser();
    if (user.getUserName() == registeredUser.getUserName() && user.getPassword() == registeredUser.getPassword()) {
      isValid = true;
    }
    return isValid;
  }
}
