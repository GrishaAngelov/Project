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
  private File downloadedFile;

  @Before
  public void setUp() {
    URL urlCar2 = getClass().getResource("car2.gif");
    downloadedFile = new File(urlCar2.getPath());
    downloadAgent = new DownloadAgent(downloadedFile, new JProgressBar());
  }

  @Test
  public void downloadResourceFromCorrectURL() throws IOException {
    URL urlCar = getClass().getResource("car.gif");
    File oldFile = new File(urlCar.getPath());
    downloadAgent.downloadFile("http://www.carinsurance75.com/blog/wp-content/uploads/2012/05/car.gif");
    assertEquals(oldFile.getTotalSpace(), downloadedFile.getTotalSpace());
  }

  @Test(expected = UnknownHostException.class)
  public void downloadResourceFromIncorrectURL() throws IOException {
    downloadAgent.downloadFile("http://akljsdh8723894.com/picturefile.jpg");
  }
}
