package com.clouway.networking.downloadagent;

import com.clouway.networking.downloadagent_.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DownloadButtonHandler implements ActionListener{
  private JFileChooser fileChooser;
  private JTextField addressBar;
  private DownloadAgent downloadAgent;

  public DownloadButtonHandler(JTextField addressBar, DownloadAgent downloadAgent) {
    this.addressBar = addressBar;
    this.downloadAgent = downloadAgent;
    fileChooser = new JFileChooser();
  }

  public void actionPerformed(ActionEvent event) {
    String filename = addressBar.getText().substring(addressBar.getText().lastIndexOf("/") + 1);
    File file = new File(filename);
    fileChooser.setSelectedFile(file);
    int userChoice = fileChooser.showSaveDialog(fileChooser);
    if (userChoice == JFileChooser.APPROVE_OPTION) {
      try {
        if (checkForIncorrectURL(addressBar.getText())) {
          URL url = new URL(addressBar.getText());
          URLConnection urlConnection = url.openConnection();
          downloadAgent.download(urlConnection, fileChooser.getSelectedFile().getPath());
        }
      } catch (IOException e) {
        JOptionPane.showMessageDialog(new JFrame(), "Not existing URL!");
      }
    }
  }

  private boolean checkForIncorrectURL(String urlString) {
    boolean isCorrectUrl = true;
    if (!urlString.startsWith("http://")) {
      JOptionPane.showMessageDialog(new JFrame(), "Incorrect URL!");
      isCorrectUrl = false;
    }
    return isCorrectUrl;
  }
}