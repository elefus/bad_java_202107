package com.bad_java.lectures._03;

public class InnerClassExample {

  private int field = 50;

  private void method() {
    int field = 22;

    System.out.println("Method from outer class = " + this.field);
  }

  public static void main(String[] args) {
//    Inner inner = new InnerClassExample().new Inner();
//    inner.method();
//    System.out.println(inner.field);

    A1 a1 = new A1();
    a1.method();
    a1 = new A2();
    a1.method();
    a1 = new A3();
    a1.method();
  }

  class Inner {

    private int field = 55;

    private void method() {
      InnerClassExample.this.method();
      System.out.println("Method from inner class = " + InnerClassExample.this.field);
    }

    class InnerInner {

      private int field = 80;

      private void method() {
        System.out.println("Method from inner class = " + field);
        System.out.println("Method from inner class = " + Inner.this.field);
        System.out.println("Method from inner class = " + InnerClassExample.this.field);
      }
    }
  }

  static class A1 {

    private void method() {
      System.out.println("A1");
    }
  }

  static class A2 extends A1 {

    public void method() {
      System.out.println("A2");
    }
  }

  static class A3 extends A2 {
    public void method() {
      System.out.println("A3");
    }
  }
}
