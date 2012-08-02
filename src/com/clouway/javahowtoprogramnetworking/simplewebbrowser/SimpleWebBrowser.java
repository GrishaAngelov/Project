package com.clouway.javahowtoprogramnetworking.simplewebbrowser;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SimpleWebBrowser extends JFrame {
  private JTextField addressBar;
  private JEditorPane contentArea;

  public SimpleWebBrowser() {
    setTitle("Simple Web Browser");

    setUpAndAddAddressBar();

    setUpAndAddContentArea();
  }

  private void setUpAndAddAddressBar() {
    addressBar = new JTextField("Enter URL");
    addressBar.addActionListener(
            new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent event) {
                getThePage(event.getActionCommand());
              }
            }
    );
    add(addressBar, BorderLayout.NORTH);
  }

  private void setUpAndAddContentArea() {
    contentArea = new JEditorPane();
    contentArea.setEditable(false);
    contentArea.addHyperlinkListener(
            new HyperlinkListener() {
              @Override
              public void hyperlinkUpdate(HyperlinkEvent hyperlinkEvent) {
                if (hyperlinkEvent.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                  getThePage(hyperlinkEvent.getURL().toString());
                }
              }
            }
    );
    add(new JScrollPane(contentArea), BorderLayout.CENTER);
    setSize(800, 600);
    setVisible(true);
  }

  private void getThePage(String pageURL) {
    try {
      contentArea.setPage(pageURL);
      addressBar.setText(pageURL);
    } catch (IOException e) {
      JOptionPane.showMessageDialog(this, "Error retrieving specified URL", "Bad URL", JOptionPane.ERROR_MESSAGE);
    }
  }
}
