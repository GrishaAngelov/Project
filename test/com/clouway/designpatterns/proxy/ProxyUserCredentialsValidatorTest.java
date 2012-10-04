package com.clouway.designpatterns.proxy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class ProxyUserCredentialsValidatorTest {
  private CredentialsValidator proxyUserCredentialsValidator;

  @Before
  public void setUp() {
    UserRegister userRegister = new UserRegister();
    userRegister.registerUser(new ForumUser("Pesho", "123456"));
    proxyUserCredentialsValidator = new ProxyUserCredentialsValidator(userRegister);
  }

  @Test
  public void validateRegisteredUser() {
    User registeredUser = new ForumUser("Pesho", "123456");
    assertEquals(true, proxyUserCredentialsValidator.validate(registeredUser));
  }

  @Test
  public void validateUnregisteredUser() {
    User unregisteredUser = new ForumUser("Ivan", "asd123");
    assertEquals(false, proxyUserCredentialsValidator.validate(unregisteredUser));
  }
}
