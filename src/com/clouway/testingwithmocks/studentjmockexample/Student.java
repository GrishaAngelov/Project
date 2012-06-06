package com.clouway.testingwithmocks.studentjmockexample;

/**
 * Created by Grisha Angelov <grisha.angelov@clouway.com>
 */
public class Student {
  private String name;
  private DisciplineRegistration disciplineRegistration;

  public Student(String name, DisciplineRegistration disciplineRegistration) {
    this.name = name;
    this.disciplineRegistration = disciplineRegistration;
  }

  public String registerThisStudentToDiscipline(String disciplineName){
    return disciplineRegistration.registerStudentToDiscipline(disciplineName);
  }
}
