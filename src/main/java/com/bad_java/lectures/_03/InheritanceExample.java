package com.bad_java.lectures._03;

import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InheritanceExample {

  public static void main(String[] args) {
//    I ref = new O();
//    ref.sayHello();
//
//    O ref2 = (O) ref;
//    ref2.sayGoodBye();

//    G ref = new F(); // [HEADER: identityHashCode + class pointer (F)][field][field2][padding]
//    ref.sayHello();
//    ref.getField();
//    ref.toString();
//    ref.abc();
//    G.shouldBePositive(10);
//    F.shouldBePositive(10);

//    F ref = new F();
//    System.out.println("Before");
//    ref.shouldBePositive(10);
//    ref.shouldBePositive(40L);
//    System.out.println("After");
//
//    P base = new K();
//    K child = (K) new P();

//    N n = (N) new M(42);
//    n.getField();

    CharSequence[] arr = new CharSequence[10];
    arr[0] = "123";
    arr[1] = CharBuffer.wrap("trt");

    // JEP - Java Enchantment Proposal
    if (!(arr[0] instanceof Object)) {

    }

    if (arr[0] instanceof String) {
      String str = (String) arr[0];
    }
  }
}

class N {
  private int field;

  public N(int field) {
    this.field = field;
  }

  public int getField() {
    return field;
  }
}

class M {
  private int field;

  public M(int field) {
    this.field = field;
  }

  public int getField() {
    return field;
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

  private int field;

  public G(int field) {
    if (field <= 0) {
      System.err.println("IllegalArgument = " + field);
    }
    this.field = field;
  }

  public void sayHello() {
    System.out.println("Hello from G");
  }

  public int getField() {
    return field;
  }

  public static final int shouldBePositive(int value) {
    System.out.println("From G");
    if (value <= 0) {
      System.err.println("IllegalArgument = " + value);
    }
    return value;
  }
}

class F extends G {

  protected int field2 = 55;

  public F(int field) {
    super(shouldBePositive(field));
  }

  public F() {
    this(55);
  }

  @Override
  public void sayHello() {
    System.out.println("Hello from F");
  }

  public void sayGoodBye() {
    System.out.println("Good bye from F" + getField());
  }

  public final long shouldBePositive(long value) {
    System.out.println("From F");
    if (value <= 0) {
      System.err.println("IllegalArgument = " + value);
    }
    return value;
  }
}


class P {

  protected Integer intValue = 1;

  public P() {
    System.out.println(this.increment());
  }

  public int increment() {
    return intValue++;
  }
}

class K extends P {

  protected int intValue = 10;

  public K() {
  }

  @Override
  public int increment() {
    System.out.println("Overridden method increment()");
    System.out.println("intValue = " + intValue);
    return intValue + super.increment();
  }
}

class Launcher {

  public static void main(String[] args) {
    K k = new K();
  }
}