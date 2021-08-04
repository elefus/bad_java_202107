package com.bad_java.lectures._03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassExample {

  private static final int STATIC_CONSTANT = 66;
  private final int nonStaticField = 77;


  public void main(int a) {
    Square sqr = new Square(10) {

      private final int a = 77;
      private final int b = 77;

      @Override
      public double calcPerimeter() {
//        System.out.println(super.a);
        System.out.println(this.b);
        System.out.println(nonStaticField);
        System.out.println(STATIC_CONSTANT);
        return Double.NEGATIVE_INFINITY;
      }
    };
  }

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
    System.out.println("List class = " + list.getClass());
    System.out.println(list);

    Square sqr = new Square(10) {
      @Override
      public double calcPerimeter() {
//        System.out.println(nonStaticField);
        System.out.println(STATIC_CONSTANT);
        return Double.NEGATIVE_INFINITY;
      }
    };

    Rectangle rect = new Rectangle(1, 2);
    AbstractGeometricShape[] shapes = {sqr, rect, new Square(20), createInfiniteShape(), createInfiniteShape()};

    System.out.println(shapes[3] == shapes[4]);
    System.out.println(shapes[3].getClass() == shapes[4].getClass());

    System.out.println(Arrays.toString(shapes));

    //    System.out.println(comparator.getClass());
//    System.out.println(comparator instanceof Comparator);
    Arrays.sort(shapes, new Comparator<AbstractGeometricShape>() {
      @Override
      public int compare(AbstractGeometricShape a, AbstractGeometricShape b) {
        return Double.compare(a.calcPerimeter(), b.calcPerimeter());
      }
    });

    System.out.println(Arrays.toString(shapes));
  }

  private static AbstractGeometricShape createInfiniteShape() {
    return new AbstractGeometricShape() {

      private final int value = 55;

      @Override
      public Number calcSquare() {
        return Double.POSITIVE_INFINITY;
      }

      @Override
      public double calcPerimeter() {
        return Double.POSITIVE_INFINITY;
      }
    };
  }

}
