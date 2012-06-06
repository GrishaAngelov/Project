package com.clouway.testingwithmocks.mockwebservice;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MockWebService implements WebService {
  private String lastError;

  public void logError(String message) {
    lastError = message;
  }

//  public String getLastErrorMessage(){
//    return lastError;
//  }
}
