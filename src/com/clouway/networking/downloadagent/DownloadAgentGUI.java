package com.clouway.networking.downloadagent;

import javax.swing.*;
import java.awt.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DownloadAgentGUI extends JFrame {
  private JTextField addressBar;
  private JProgressBar progressBar;
  private JButton downloadButton;

  public DownloadAgentGUI() {
    setTitle("DownloadAgent");
    setLayout(new FlowLayout());
    add(new Label("enter URL"));

    addressBar = new JTextField();
    addressBar.setColumns(20);
    add(addressBar);

    progressBar = new JProgressBar();
    progressBar.setStringPainted(true);
    add(progressBar);

    downloadButton = new JButton("Download");
    downloadButton.addActionListener(new DownloadButtonHandler(addressBar, progressBar));
    add(downloadButton);
  }
}
