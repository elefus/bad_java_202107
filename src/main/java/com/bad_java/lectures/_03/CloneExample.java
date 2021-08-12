package com.bad_java.lectures._03;

import java.util.Arrays;

public class CloneExample {

  public static void main(String[] args) {
    Color black = new Color(1, 1, 1);
    Color clonedColor = black.clone();

    System.out.println(black.hashCode());
    System.out.println(clonedColor.hashCode());
    System.out.println(black == clonedColor);
    System.out.println(black.equals(clonedColor));
    System.out.println(clonedColor);


    String[] users = {"A", "B", "C"};

    Users users1 = new Users(users);
    Users users2 = users1.clone();

    System.out.println(Arrays.toString(users));
    users1.getArr()[0] = "AA";

    System.out.println(Arrays.toString(users));
    users2.getArr()[1] = "BB";

    System.out.println(Arrays.toString(users2.getArr()));

    Users clone = new Users(users2);

  }
}


class Users implements Cloneable {

  private final String[] arr;

  public Users(String[] arr) {
    this.arr = arr;
  }

  public Users(Users other) {
    arr = Arrays.copyOf(other.arr, other.arr.length);
  }

  public String[] getArr() {
    return arr;
  }

  @Override
  public Users clone() {
    try {
      Users clone = (Users) super.clone();
//      clone.arr = Arrays.copyOf(arr, arr.length);
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError(e);
    }
  }
}
