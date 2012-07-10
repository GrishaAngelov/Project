package com.clouway.gui.thirdcalculator;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Calculator extends JFrame {
  private CalculatorTextFieldImpl textField = new CalculatorTextFieldImpl(new JTextField());

  private Container container;

  public void setContainerAndTextField(){
    container = getContentPane();
    container.setBackground(Color.ORANGE);
    setLayout(new FlowLayout());
    textField.setColumns(20);
    textField.setEditable(false);
    textField.setHorizontalAlignment(SwingConstants.RIGHT);
    add(textField);
  }

  public void addButtons(List assignedButtonList) {
    for (int i = 0; i < assignedButtonList.size(); i++) {
      add((JButton) assignedButtonList.get(i));
    }
  }

  public Calculator(List<JButton> buttons ,List<JButton> operationButtons) {
     setContainerAndTextField();

    ButtonListenerAssigner buttonListenerAssigner = new ButtonListenerAssigner(buttons, new ButtonNumberHandler(textField));
    buttonListenerAssigner.assign();
    List assignedButtonsList = buttonListenerAssigner.getAssignedButtonList();
    addButtons(assignedButtonsList);

//    buttons = new String[]{"+","-","*","/"};

  }


}
