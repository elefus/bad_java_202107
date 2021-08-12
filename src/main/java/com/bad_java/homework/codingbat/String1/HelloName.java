package com.bad_java.homework.codingbat.String1;

//Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
public class HelloName {

  public static String helloName(String name) {
    return "Hello " + name + "!";
  }

  public static void main(String[] args) {
    System.out.println(helloName("Bob"));
  }
}
