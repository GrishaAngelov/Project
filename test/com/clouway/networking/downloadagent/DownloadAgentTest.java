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
  private DownloadAgent agent;

  @Before
  public void setUp() {
    agent = new DownloadAgent();
  }

  @Test
  public void downloadResourceFromExistingURL() throws IOException {
    File oldFile = new File("car.gif");
    File downloadedFile = new File("car2.gif");
    agent.download(new URL("http://www.carinsurance75.com/blog/wp-content/uploads/2012/05/car.gif").openConnection(), "car2.gif");
    assertEquals(oldFile.getTotalSpace(), downloadedFile.getTotalSpace());
  }

  @Test(expected = UnknownHostException.class)
  public void downloadResourceFromNotExistingURL() throws IOException {
    agent.download(new URL("http://akljsdh8723894.com/picturefile.jpg").openConnection(),"car.gif");
  }
}
