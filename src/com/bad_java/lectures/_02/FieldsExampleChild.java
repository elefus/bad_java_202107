package com.bad_java.lectures._02;

import com.bad_java.lectures._03.FieldsExample;

public class FieldsExampleChild extends FieldsExample {

  public static void main(String[] args) {
    System.out.println(FieldsExample.protectedStaticValue);


  }

  private void method() {
    FieldsExample ref = new FieldsExample();
    System.out.println(this.protectedValue);
  }
}
