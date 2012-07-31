package com.clouway.networking.downloadagent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DownloadButtonHandler implements ActionListener {

  private JFileChooser fileChooser = new JFileChooser();
  private DownloadAgent downloadAgent = new DownloadAgent();
  private JTextField addressBar;

  public DownloadButtonHandler(JTextField addressBar, DownloadAgent downloadAgent) {
    this.addressBar = addressBar;
    this.downloadAgent = downloadAgent;
  }

  public void actionPerformed(ActionEvent event) {
    String filename = addressBar.getText().substring(addressBar.getText().lastIndexOf("/") + 1);
    File file = new File(filename);
    fileChooser.setSelectedFile(file);
    int userChoice = fileChooser.showSaveDialog(fileChooser);
    if (userChoice == JFileChooser.APPROVE_OPTION) {
      try {
        File downloadFile = new File(fileChooser.getSelectedFile().getPath());
        downloadAgent.setFile(downloadFile);
        downloadAgent.downloadFile(addressBar.getText());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}