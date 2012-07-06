package com.clouway.gui.secondcalculator;

import java.util.List;

/**
* @author Grisha Angelov <grisha.angelov@clouway.com>
*/
interface MathCalculator {

  boolean isCalculationOperation(String operationName);

  int calculate(List<String> operationStack);

}
