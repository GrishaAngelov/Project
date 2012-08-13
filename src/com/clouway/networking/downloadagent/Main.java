package com.clouway.networking.downloadagent;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Main {
  public static void main(String[] args) throws IOException {
    JFrame agentUI = new JFrame();
    agentUI.setTitle("DownloadAgent");
    agentUI.setLayout(new FlowLayout());
    agentUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    agentUI.setVisible(true);
    agentUI.setSize(250, 150);
    agentUI.setLocation(500, 200);
    agentUI.setResizable(false);

    agentUI.add(new Label("enter URL"));

    JTextField addressBar = new JTextField();
    addressBar.setColumns(20);
    agentUI.add(addressBar);

    JButton downloadButton = new JButton("Download");
    agentUI.add(downloadButton);

    DownloadAgent downloadAgent = new DownloadAgent();
    JProgressBar jProgressBar = new JProgressBar();
    ProgressBar progressBar = new ProgressBar(jProgressBar);
    jProgressBar.setStringPainted(true);
    agentUI.add(jProgressBar);
    downloadAgent.addObserver(progressBar);
    downloadButton.addActionListener(new DownloadButtonHandler(addressBar, downloadAgent));
  }
}
