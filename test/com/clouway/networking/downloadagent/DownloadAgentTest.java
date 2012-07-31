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
    downloadAgent = new DownloadAgent();
  }

  @Test
  public void downloadResourceFromCorrectURL() throws IOException {
    File oldFile = new File("/home/clouway/workspace/Project/test/com/clouway/networking/downloadagent/car.gif");
    File downloadedFile = new File("/home/clouway/workspace/Project/test/com/clouway/networking/downloadagent/car2.gif");
    downloadAgent.setFile(downloadedFile);
    downloadAgent.setProgressBar(new JProgressBar());
    downloadAgent.downloadFile("http://www.carinsurance75.com/blog/wp-content/uploads/2012/05/car.gif");
    assertEquals(oldFile.getTotalSpace(), downloadedFile.getTotalSpace());
  }

  @Test(expected = UnknownHostException.class)
  public void downloadResourceFromIncorrectURL() throws IOException {
    downloadAgent.setProgressBar(new JProgressBar());
    downloadAgent.downloadFile("http://akljsdh8723894.com/picturefile.jpg");
  }
}
