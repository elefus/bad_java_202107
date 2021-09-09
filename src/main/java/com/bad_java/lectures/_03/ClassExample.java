package com.bad_java.lectures._03;

public abstract class ClassExample {

  public static void main(String[] args) {
    // Early binding [static binding]
    // Late binding [dynamic binding]

    System.out.println(FieldsExample.packageStaticValue);
    System.out.println(FieldsExample.protectedStaticValue);

    FieldsExample ref = new FieldsExample();
    System.out.println(ref.protectedValue);
  }

  /*
  [specifiers] class ClassName [extends SuperClass] [implements IFace1, IFace2 .. ] {
    // Definition
        state
          fields
          static fields

        construction
          constructors
          init-blocks

        behavior
          methods
          static methods

  }

  specifiers:
    public
    package-visible
    final
    abstract
   */

}

class A {

}