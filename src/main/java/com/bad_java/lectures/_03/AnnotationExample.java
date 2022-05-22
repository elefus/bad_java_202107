package com.bad_java.lectures._03;

import com.bad_java.lectures._03.Measurable.Mode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@SuppressWarnings({"DefaultAnnotationParam", "unused"})
@Deprecated(since = "1.4.7", forRemoval = false)
public class AnnotationExample {

  @Measurable(mode = Mode.TIME)
  public static void main(String[] args) {
    Class<AnnotationExample> clazz = AnnotationExample.class;

    Method[] methods = clazz.getMethods();
    for (Method method : methods) {
      Measurable measurable = method.getAnnotation(Measurable.class);
      if (measurable != null) {
        System.out.println("For method " + method + " we have following values: ");
        System.out.println(measurable.mode());
        System.out.println(measurable.units());
      }
    }
//    if (clazz.isAnnotationPresent(Deprecated.class)) {
//      Deprecated annotation = clazz.getAnnotation(Deprecated.class);
//      System.out.println(annotation.since());
//      System.out.println(annotation.forRemoval());
//    } else {
//      System.out.println("@Deprecated is not presented for this class");
//    }


  }

  @Measurable(mode = Mode.THROUGHPUT)
  public static void calculate() {

  }

  @Measurable(units = TimeUnit.DAYS)
  public static void anotherMethod() {

  }

  public static void nonMeasurable() {
    int a = 123;
  }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Measurable {

  Mode mode() default Mode.TIME;

  TimeUnit units() default TimeUnit.SECONDS;

  enum Mode {
    TIME,
    THROUGHPUT
  }
}

@SuppressWarnings("unused")
class H {

  @Override
  public String toString() {
    return super.toString();
  }
}


