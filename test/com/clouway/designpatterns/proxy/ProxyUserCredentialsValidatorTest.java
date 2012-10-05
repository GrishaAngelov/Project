package com.clouway.designpatterns.proxy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ProxyUserCredentialsValidatorTest {
  private CredentialsValidator userCredentialsValidator;
  private CredentialsValidator proxyUserCredentialsValidator;
  private UserRegister userRegister;
  private User user;

  @Before
  public void setUp() {
    userRegister = new UserRegister();
    user = new ForumUser("Pesho", "123456");
    userCredentialsValidator = new UserCredentialsValidator(userRegister);
    proxyUserCredentialsValidator = new ProxyUserCredentialsValidator(userRegister);
  }

  @Test
  public void validateRegisteredUser() {
    userRegister.registerUser(user);
    assertUserValidation(user, true);
  }

  @Test
  public void validateUnregisteredUser() {
    assertUserValidation(user, false);
  }

  private void assertUserValidation(User user, boolean isValid) {
    assertEquals(isValid, userCredentialsValidator.validate(user));
    assertEquals(isValid, proxyUserCredentialsValidator.validate(user));
  }
}
