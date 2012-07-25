package com.clouway.gui.calculatortask;


import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Calculator extends JFrame {
  private JTextField field = new JTextField();
  private CalculatorTextField textField = new CalculatorTextFieldImpl(field);
  private ALWrapperDot wrapperDot = new ALWrapperDot();
  private ALWrapperClearAll wrapperClearAll = new ALWrapperClearAll();
  private ALWrapperClearLastSymbol wrapperClearLastSymbol = new ALWrapperClearLastSymbol();

  public Calculator(List<JButton> numbersAndOperationsButtonsList, List<JButton> specialButtonsList) {
    setContainerAndTextField();

    assignAndAddNumbersAndOperations(numbersAndOperationsButtonsList);

    createSpecialButtons(specialButtonsList);
  }

  private void assignAndAddNumbersAndOperations(List<JButton> numberButtonsList) {
    ButtonListenerAssigner buttonListenerAssigner = new ButtonListenerAssigner(numberButtonsList, new ButtonHandler(textField));
    assignAndAdd(numberButtonsList, buttonListenerAssigner);

  }

  public void setContainerAndTextField() {
    setTitle("calculator");
    Container container = getContentPane();
    container.setBackground(Color.ORANGE);
    setLayout(new FlowLayout());
    add(field);
  }

  public void createSpecialButtons(List<JButton> specialButtonsList) {
    ButtonListenerAssigner specialButtonListenerAssigner = new ButtonListenerAssigner();
    add(specialButtonListenerAssigner.assignListenerToSingleButton(specialButtonsList.get(0), new EqualsHandler(textField)));
    add(specialButtonListenerAssigner.assignListenerToSingleButton(specialButtonsList.get(1), new SpecialButtonHandler(wrapperDot, textField)));
    add(specialButtonListenerAssigner.assignListenerToSingleButton(specialButtonsList.get(2), new SpecialButtonHandler(wrapperClearAll, textField)));
    add(specialButtonListenerAssigner.assignListenerToSingleButton(specialButtonsList.get(3), new SpecialButtonHandler(wrapperClearLastSymbol, textField)));
  }

  private void addButtons(List<JButton> assignedButtonList) {
    for (int i = 0; i < assignedButtonList.size(); i++) {
      add(assignedButtonList.get(i));
    }
  }

  private void assignAndAdd(List<JButton> buttonsList, ButtonListenerAssigner buttonListenerAssigner) {
    buttonsList = buttonListenerAssigner.assignListenerToButtonList();
    addButtons(buttonsList);
  }


}