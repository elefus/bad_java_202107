package com.bad_java.lectures._03;

import java.io.Serializable;

public class AbstractClassesExample {

  public static void main(String[] args) {
    Rectangle rectangle = new Square(10);

    System.out.println(rectangle.calcSquare() == 100);

//    rectangle.setA(15);
    System.out.println(rectangle.calcSquare() == 150);

    AbstractGeometricShape shape = new Rectangle(1, 2);
    System.out.println(shape.getPoint2d());

    Integer squareSquare = rectangle.calcSquare();
    Number rectangleSquare = shape.calcSquare();
    int max;
    if (squareSquare >= rectangleSquare.intValue()) {
      max = squareSquare;
    } else {
      max = rectangleSquare.intValue();
    }


  }
}

class Point2d {

  int x;
  int y;

  @Override
  public String toString() {
    return "Point2d{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}

abstract class AbstractGeometricShape implements Movable, Movable2, Cloneable, Serializable, Comparable {

  protected Point2d point2d;

  public AbstractGeometricShape(Point2d point2d) {
    this.point2d = point2d;
  }

  public AbstractGeometricShape() {
    this.point2d = new Point2d();
  }

  public abstract Number calcSquare();

  public abstract double calcPerimeter();

  public Point2d getPoint2d() {
    return point2d;
  }

  public static int method() {
    return 42;
  }

  @Override
  public Point2d move(Point2d point) {
    return null;
  }

  @Override
  public Point2d move(int diffX, int diffY) {
    return null;
  }

  @Override
  public String getStr() {
    return "getStr called";
  }

  @Override
  public int compareTo(Object o) {
    AbstractGeometricShape other = (AbstractGeometricShape) o;
    return Double.compare(calcSquare().doubleValue(), other.calcSquare().doubleValue());
  }

  @Override
  public String toString() {
    return "AbstractGeometricShape{" +
        "point2d=" + point2d +
        '}';
  }
}

class Rectangle extends AbstractGeometricShape {

  private final int a;
  private final int b;

  public Rectangle(Point2d point, int a, int b) {
    super(point);
    this.a = a;
    this.b = b;
  }

  public Rectangle(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public int getA() {
    return a;
  }

  public int getB() {
    return b;
  }

  @Override
  public Integer calcSquare() {
    return a * b;
  }

  @Override
  public double calcPerimeter() {
    return 2 * (a + b);
  }

  @Override
  public String toString() {
    return "Rectangle{" +
        "a=" + a +
        ", b=" + b +
        '}';
  }
}

class Square extends Rectangle {

  public Square(Point2d point, int a) {
    super(point, a, a);
  }

  public Square(int a) {
    super(a, a);
  }

  @Override
  public double calcPerimeter() {
    return getA() * 4;
  }

  @Override
  public String toString() {
//    super.toString();
//    super.super.toString(); // ERROR
    return "Square{" +
        "point2d=" + point2d + "," +
        "side=" + getA() +
        '}';
  }
}