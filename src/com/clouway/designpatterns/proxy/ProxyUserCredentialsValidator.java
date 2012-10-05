package com.clouway.designpatterns.proxy;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ProxyUserCredentialsValidator implements CredentialsValidator {
  private UserRegister userRegister;
  private UserCredentialsValidator userCredentialsValidator;

  public ProxyUserCredentialsValidator(UserRegister userRegister) {
    this.userRegister = userRegister;
  }

  @Override
  public boolean validate(User user) {
    if (userCredentialsValidator == null) {
      userCredentialsValidator = new UserCredentialsValidator(userRegister);
    }
    return userCredentialsValidator.validate(user);
  }
}
