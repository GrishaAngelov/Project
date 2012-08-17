package com.clouway.networking.downloadagent;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DownloadButtonHandler implements ActionListener {
  private JFileChooser fileChooser;
  private JTextField addressBar;
  private DownloadAgent downloadAgent;

  public DownloadButtonHandler(JTextField addressBar, DownloadAgent downloadAgent, JFileChooser fileChooser) {
    this.addressBar = addressBar;
    this.downloadAgent = downloadAgent;
    this.fileChooser = fileChooser;
  }

  /**
   * Performs downloading of a web resource after the user click
   * download button and choose where to save his file
   *
   * @param event
   */
  public void actionPerformed(ActionEvent event) {
    String filename = addressBar.getText().substring(addressBar.getText().lastIndexOf("/") + 1);
    fileChooser.setSelectedFile(new File(filename));
    int userChoice = fileChooser.showSaveDialog(fileChooser);
    if (userChoice == JFileChooser.APPROVE_OPTION) {
      Thread updateThread = new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            if (isCorrectURL(addressBar.getText())) {
              URL url = new URL(addressBar.getText());
              URLConnection urlConnection = url.openConnection();
              File file = new File(fileChooser.getSelectedFile().getPath());
              FileOutputStream fileOutputStream = new FileOutputStream(file);
              downloadAgent.download(urlConnection.getInputStream(), fileOutputStream, urlConnection.getContentLength());
            }
          } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Not existing URL!");
          }
        }
      });
      updateThread.start();
    }
  }

  /**
   * Check whether given url starts with the http protocol
   *
   * @param urlString
   * @return
   */
  private boolean isCorrectURL(String urlString) {
    boolean isCorrectUrl = true;
    if (!urlString.startsWith("http://")) {
      JOptionPane.showMessageDialog(new JFrame(), "Incorrect URL!");
      isCorrectUrl = false;
    }
    return isCorrectUrl;
  }
}