package com.clouway.gui.calculatortask;


import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class CalculatorUI extends JFrame {
  private JTextField field = new JTextField();
  private CalculatorTextField textField = new CalculatorTextFieldImpl(field);
  private DotListener dotListener = new DotListener();
  private ClearAllListener clearAllListener = new ClearAllListener();
  private ClearLastSymbolListener clearLastSymbolListener = new ClearLastSymbolListener();
  private ButtonBuilderImpl buttonBuilderImpl = new ButtonBuilderImpl();

  public CalculatorUI() {
    setContainerAndTextField();

    addNumbersAndOperationsButtons();

    addFunctionButtons();
  }

  public void setContainerAndTextField() {
    setTitle("calculator");
    Container container = getContentPane();
    container.setBackground(Color.ORANGE);
    setLayout(new FlowLayout());
    add(field);
  }

  private void addNumbersAndOperationsButtons() {
    List<JButton> buttonList = buttonBuilderImpl.buildButtons(
            new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "+", "-", "*", "/"},new NumbersAndOperationsClickButtonListener(textField));
    for(JButton button:buttonList){
      add(button);
    }
  }

  private void addFunctionButtons() {
    add(buttonBuilderImpl.buildButton("=",new EqualsListener(textField)));
    add(buttonBuilderImpl.buildButton(".",new FunctionalButtonListener(dotListener,textField)));
    add(buttonBuilderImpl.buildButton("clr",new FunctionalButtonListener(clearAllListener, textField)));
    add(buttonBuilderImpl.buildButton("<-",new FunctionalButtonListener(clearLastSymbolListener,textField)));
  }
}