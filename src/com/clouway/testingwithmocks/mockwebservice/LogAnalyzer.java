package com.clouway.testingwithmocks.mockwebservice;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class LogAnalyzer {
  private MockWebService service;
  private int minimalFilenameLength = 5;

  public LogAnalyzer(MockWebService service) {
    this.service = service;
  }

  public boolean analyzeIsFilenameTooShort(String filename) {
    if(filename.length() == 0){
      throw new EmptyFilenameException();
    }
    else if (filename.length() < minimalFilenameLength) {
      service.logError
              (String.format("Filename is too short! Required at least %d characters.", minimalFilenameLength));
      return false;
    }
    return true;
  }
}
