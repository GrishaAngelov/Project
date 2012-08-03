package com.clouway.networking.downloadagent;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.*;
import java.net.*;

import static junit.framework.Assert.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DownloadAgentTest {
  private DownloadAgent downloadAgent;

  @Before
  public void setUp() {
    downloadAgent = new DownloadAgent(getClass().getResource("car.gif").getPath());
  }

  @Test
  public void downloadResourceFromCorrectURL() throws IOException {
    File oldFile = new File(getClass().getResource("car.gif").getPath());
    File downloadedFile = downloadAgent.downloadFile("http://www.carinsurance75.com/blog/wp-content/uploads/2012/05/car.gif");
    assertEquals(oldFile.getTotalSpace(), downloadedFile.getTotalSpace());
  }

  @Test(expected = UnknownHostException.class)
  public void downloadResourceFromIncorrectURL() throws IOException {
    downloadAgent.downloadFile("http://akljsdh8723894.com/picturefile.jpg");
  }
}
