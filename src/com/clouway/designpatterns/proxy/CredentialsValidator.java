package com.clouway.designpatterns.proxy;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public interface CredentialsValidator {
  boolean validate(User user);
}
