package com.clouway.gui.thirdcalculator;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Calculator extends JFrame {
  private CalculatorTextField textField = new CalculatorTextFieldImpl(new JTextField());
  private OperandsAndOperationProvider operandsAndOperationProvider = new OperandsAndOperationProvider();
  private ButtonListenerAssigner buttonNumberListenerAssigner;
  private ButtonListenerAssigner buttonOperationListenerAssigner;
  private ButtonListenerAssigner specialButtonListenerAssigner;
  private List<JButton> numberButtonsList;
  private List<JButton> operationButtonsList;
  private Container container;
  private Operator operator = new Operator();
  private ALWrapperDot wrapperDot = new ALWrapperDot();
  private ALWrapperClearAll wrapperClearAll = new ALWrapperClearAll();
  private ALWrapperClearLastSymbol wrapperClearLastSymbol = new ALWrapperClearLastSymbol();

  public void setContainerAndTextField() {
    setTitle("calculator");
    container = getContentPane();
    container.setBackground(Color.ORANGE);
    setLayout(new FlowLayout());
    add(textField.getField());
  }

  public void createSpecialButtons(List<JButton> specialButtons) {
    specialButtonListenerAssigner = new ButtonListenerAssigner();
    add(specialButtonListenerAssigner.assignListenerToSingleButton(specialButtons.get(0), new EqualsHandler(textField, operator, operandsAndOperationProvider)));
    add(specialButtonListenerAssigner.assignListenerToSingleButton(specialButtons.get(1), new ButtonHandler(wrapperDot, textField)));
    add(specialButtonListenerAssigner.assignListenerToSingleButton(specialButtons.get(2), new ButtonHandler(wrapperClearAll, textField)));
    add(specialButtonListenerAssigner.assignListenerToSingleButton(specialButtons.get(3), new ButtonHandler(wrapperClearLastSymbol, textField)));
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

  public Calculator(List<JButton> buttons, List<JButton> operationButtons, List<JButton> specialButtons) {
    setContainerAndTextField();

    buttonNumberListenerAssigner = new ButtonListenerAssigner(buttons, new ButtonNumberHandler(textField));
    assignAndAdd(numberButtonsList, buttonNumberListenerAssigner);

    buttonOperationListenerAssigner = new ButtonListenerAssigner(operationButtons, new OperationButtonHandler(textField, operandsAndOperationProvider));
    assignAndAdd(operationButtonsList, buttonOperationListenerAssigner);

    createSpecialButtons(specialButtons);
  }
}
