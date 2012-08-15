package com.clouway.networking.downloadagent;


import org.junit.Before;
import org.junit.Test;

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
    URLConnection connection = new URL("http://www.carinsurance75.com/blog/wp-content/uploads/2012/05/car.gif").openConnection();
    InputStream inputStream = connection.getInputStream();
    File  downloadedFile = new File("downloadedCar.gif");
    int contentSize = connection.getContentLength();
    agent.download(inputStream, new FileOutputStream(downloadedFile), contentSize);
    assertEquals(getClass().getResourceAsStream("car.gif").read(), getClass().getResourceAsStream("downloadedCar.gif").read());
  }

  @Test(expected = UnknownHostException.class)
  public void downloadResourceFromNotExistingURL() throws IOException {
    int contentSize = new URL("http://www.carinsurance75.com/blog/wp-content/uploads/2012/05/car.gif").openConnection().getContentLength();
    File  downloadedFile = new File("downloadedCar.gif");
    agent.download(new URL("http://akjsdh.com/picture.jpg").openConnection().getInputStream(), new FileOutputStream(downloadedFile), contentSize);
  }
}
