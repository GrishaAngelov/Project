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
  private File oldFile;
  private File downloadedFile;

  @Before
  public void setUp() {
    agent = new DownloadAgent();
    oldFile = new File(getClass().getResource("car.gif").getPath());
    downloadedFile = new File("car2.gif");
  }

  @Test
  public void downloadResourceFromExistingURL() throws IOException {
    agent.download(new URL("http://www.carinsurance75.com/blog/wp-content/uploads/2012/05/car.gif").openConnection(), new FileOutputStream(downloadedFile));
    assertEquals(oldFile.getTotalSpace(), downloadedFile.getTotalSpace());
  }

  @Test(expected = UnknownHostException.class)
  public void downloadResourceFromNotExistingURL() throws IOException {
    agent.download(new URL("http://akljsdh8723894.com/picturefile.jpg").openConnection(), new FileOutputStream(downloadedFile));
  }
}
