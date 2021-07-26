package com.bad_java.lectures._03;

public class InheritanceExample {

  public static void main(String[] args) {
    I ref = new O();
    ref.sayHello();

    O ref2 = (O) ref;
    ref2.sayGoodBye();
  }

}

@SuppressWarnings("ALL")
class Y {

  static int basicStaticField = 0;
  static {
    basicStaticField = 1;
  }

  int basicField = 3;
  {
    basicField = 4;
  }

  public Y() {
    basicField = 5;
  }

  {
    basicField = 6;
  }
}

@SuppressWarnings("ALL")
class T extends Y {

  static int childStaticField = 0;
  static {
    childStaticField = 1;
  }

  int childField = 3;
  {
    childField = 4;
  }

  public T() {
    super();
    childField = 5;
    System.out.println("");
  }

  {
    childField = 6;
  }

  public static void main(String[] args) {
    new T();
    new T();
  }

}


class G {

  protected int field;

  public G(int field) {
    if (field <= 0) {
      System.err.println("IllegalArgument = " + field);
    }
    this.field = field;
  }

  public void sayHello() {
    System.out.println("Hello from G");
  }
}

class F extends I {

  protected int field2 = 55;

  public F(int field) {
    super(shouldBePositive(field));
  }

  public F() {
    this(55);
  }

  public void sayGoodBye() {
    System.out.println("Good bye from F" + field);
  }

  private static int shouldBePositive(int value) {
    if (value <= 0) {
      System.err.println("IllegalArgument = " + value);
    }
    return value;
  }
}