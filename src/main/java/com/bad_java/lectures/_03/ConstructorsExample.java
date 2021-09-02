package com.bad_java.lectures._03;

public class ConstructorsExample {

  public static void main(String[] args) {
//    B.callMe();
//    B instance = B.getInstance();
//    instance.method();

//    C withParam = new C(100);
//    System.out.println(withParam);

    C withoutParam = new C();
    System.out.println(withoutParam);

//    try {
//      System.out.println(D.staticField);
//    } catch (Throwable ex) {
//      System.out.println("Error catched");
//    }
//    System.out.println(D.staticField);

  }
}

@SuppressWarnings("UnusedAssignment")
class E {

  public static int staticField = 42;

  static {
    staticField = 80;
  }

  public int field = 55;

  {
    field = 77;
  }

  public E() {
    field = 66;
  }

  public static void main(String[] args) {
    System.out.println(E.staticField);
    // static field = 80

    System.out.println(new E().field);
    // field = 66

    E ref1 = new E();
    E ref2 = new E();
    E ref3 = new E();

    ref1.getField();
    ref2.getField();
    ref3.getField();

    // [HEADER][FIELDS - 4 bytes]
    // [HEADER][FIELDS - 4 bytes]
    // [HEADER][FIELDS - 4 bytes]

    Long longVal = 555L;
  }

  public int getField() {
    return field;
  }
}

class D {

  static {
    System.out.println("Static#1 = " + D.staticField);
  }

  public static int staticField = 42;

  static {
    System.out.println("Static#2" + staticField);
    System.out.println(1 / 0);
  }
}

class C {

  {
    System.out.println("1 = " + this.field);
  }

  private int field;

  {
    System.out.println("2 = " + field);
    field = -1;
  }

  public C(int field) {
    System.out.println("Ctor with param");
    this.field = field;
  }

  public C() {
    this(42);
    System.out.println("Ctor without params");
  }

  {
    System.out.println("3 = " + field);
  }

  @Override
  public String toString() {
    return "C{" +
        "field=" + field +
        '}';
  }
}

class B {

  private static final B INSTANCE = new B();

  private B() {}

  public void method() {

  }

  public static void callMe() {
    System.out.println("callMe");
  }

  public static B getInstance() {
    return INSTANCE;
  }
}
