package com.bad_java.lectures._03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Deprecated(since = "1.4.5", forRemoval = true)
public class AnnotationExample {


  public static void main(String[] args) {

  }

  @Measurable
  public static void calculate() {

  }
}

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
@interface Measurable {

}

class H {

  @Override
  public String toString() {
    return super.toString();
  }
}


