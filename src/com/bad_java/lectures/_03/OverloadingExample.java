package com.bad_java.lectures._03;

import java.util.Arrays;

public class OverloadingExample {

  public static void main(String...args) {
    // Object
    // Number
    // Integer Short Long

     method1(1, Integer.valueOf(1));
//     method1(1, 1.0);

    varargs();
    varargs(1);
    varargs(1, 2);
    varargs(1, 2, 3);
    varargs(1, 2, 3, 4);
  }

  public static void method1(Object obj, Number num) {

  }

  public static void method1(Number obj, Integer num) {

  }

  public static void method1(int intVal, Integer num) {

  }

  public static void method1(Object intVal, double num) {

  }

  public static void varargs(int... values) {
    System.out.println(Arrays.toString(values));
  }

  public static void varargs(int a, int b) {
    System.out.println("2 args");
  }
}
