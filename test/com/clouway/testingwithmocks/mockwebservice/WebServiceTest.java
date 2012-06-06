package com.clouway.testingwithmocks.mockwebservice;

import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class WebServiceTest {

  private MockWebService mockWebService;
  private LogAnalyzer logAnalyzer;
  private String shortFilename;
  private String longFilename;

  @Before
  public void setUp() {
    mockWebService = new MockWebService();
    logAnalyzer = new LogAnalyzer(mockWebService);
    shortFilename = "doc";
    longFilename = "document";
  }

  @Test
  public void testAnalyzeShortFilename() {
    boolean isShort = logAnalyzer.analyzeIsFilenameTooShort(shortFilename);
    assertEquals(false, isShort);
  }

//  @Test (expected = AssertionError.class)
//  public void testAnalyzeShortFilenameAgain() {
//    boolean isShort = logAnalyzer.analyzeIsFilenameTooShort(shortFilename);
//    assertEquals(mockWebService.getLastErrorMessage(),true, isShort);
//  }

  @Test
  public void testAnalyzeLongFilename() {
    boolean isShort = logAnalyzer.analyzeIsFilenameTooShort(longFilename);
    assertEquals(true, isShort);
  }

  @Test(expected = EmptyFilenameException.class)
  public void testEmptyFilename() {
    String filename = "";
    logAnalyzer.analyzeIsFilenameTooShort(filename);
  }

  @Test(expected = NullPointerException.class)
  public void testNullFilename() {
    String nullFilename = null;
    logAnalyzer.analyzeIsFilenameTooShort(nullFilename);
  }
}
