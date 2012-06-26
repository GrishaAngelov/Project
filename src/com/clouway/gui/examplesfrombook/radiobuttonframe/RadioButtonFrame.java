package com.clouway.gui.examplesfrombook.radiobuttonframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class RadioButtonFrame extends JFrame {
  private JTextField textField;

  private Font plainFont;
  private Font boldFont;
  private Font italicFont;
  private Font boldAndItalicFont;

  private JRadioButton plainRadioButton;
  private JRadioButton boldRadioButton;
  private JRadioButton italicRadioButton;
  private JRadioButton boldAndItalicRadioButton;

  private ButtonGroup buttonRadioGroup;

  public RadioButtonFrame() {
    super("Radio buttons");
    setLayout(new FlowLayout());

    textField = new JTextField("This is sample text");
    textField.setHorizontalAlignment(SwingConstants.CENTER);
    textField.setColumns(20);
    add(textField);

    // Create radio buttons
    plainRadioButton = new JRadioButton("Plain", true);
    boldRadioButton = new JRadioButton("Bold", false);
    italicRadioButton = new JRadioButton("Italic", false);
    boldAndItalicRadioButton = new JRadioButton("Bold/Italic", false);
    add(plainRadioButton);
    add(boldRadioButton);
    add(italicRadioButton);
    add(boldAndItalicRadioButton);

    // Create relationship between buttons
    buttonRadioGroup = new ButtonGroup();
    buttonRadioGroup.add(plainRadioButton);
    buttonRadioGroup.add(boldRadioButton);
    buttonRadioGroup.add(italicRadioButton);
    buttonRadioGroup.add(boldAndItalicRadioButton);

    // Create fonts
    plainFont = new Font("Serif", Font.PLAIN, 14);
    boldFont = new Font("Serif", Font.BOLD, 14);
    italicFont = new Font("Serif", Font.ITALIC, 14);
    boldAndItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);

    plainRadioButton.addItemListener(new RadioButtonHandler(plainFont));
    boldRadioButton.addItemListener(new RadioButtonHandler(boldFont));
    italicRadioButton.addItemListener(new RadioButtonHandler(italicFont));
    boldAndItalicRadioButton.addItemListener(new RadioButtonHandler(boldAndItalicFont));

  }

  private class RadioButtonHandler implements ItemListener {
    private Font font;

    public RadioButtonHandler(Font font) {
      this.font = font;
    }

    public void itemStateChanged(ItemEvent itemEvent) {
      textField.setFont(font);
    }
  }
}