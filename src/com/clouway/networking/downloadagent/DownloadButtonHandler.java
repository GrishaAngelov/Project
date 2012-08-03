package com.clouway.networking.downloadagent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DownloadButtonHandler implements ActionListener, Observer {

  private JFileChooser fileChooser = new JFileChooser();
  private JTextField addressBar;
  private JProgressBar progressBar;

  public DownloadButtonHandler(JTextField addressBar, JProgressBar progressBar) {
    this.addressBar = addressBar;
    this.progressBar = progressBar;
    progressBar.setStringPainted(true);
  }

  public void actionPerformed(ActionEvent event) {
    String filename = addressBar.getText().substring(addressBar.getText().lastIndexOf("/") + 1);
    File file = new File(filename);
    fileChooser.setSelectedFile(file);
    int userChoice = fileChooser.showSaveDialog(fileChooser);
    if (userChoice == JFileChooser.APPROVE_OPTION) {
      try {
        DownloadAgent downloadAgent = new DownloadAgent(fileChooser.getSelectedFile().getPath());
        downloadAgent.addObserver(this);
        downloadAgent.downloadFile(addressBar.getText());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void update(Observable observable, Object o) {
    progressBar.setValue((Integer)o);
  }
}