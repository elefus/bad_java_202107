package com.bad_java.lectures._03;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashcodeExample {

  public static void main(String[] args) {
//    Color black = new Color(0, 0, 0);
//    Color white = new Color(255, 255, 255);
//    Color white2 = new Color(255, 255, 255);
//
//    System.out.println(black.hashCode());
//    System.out.println(white.hashCode());
//    System.out.println(white2.hashCode());

    Color red = new Color(255, 0, 0);
    Color green = new Color(0, 255, 0);
    Color blue = new Color(0, 0, 255);
    Color white = new Color(255, 255, 255);
    System.out.printf("%06X%n", red.hashCode());
    System.out.printf("%06X%n", green.hashCode());
    System.out.printf("%06X%n", blue.hashCode());
    System.out.printf("%06X%n", white.hashCode());
    System.out.println(green.equals(blue));

//    User user = new User(0, "user#0");
//    Set<User> users = new HashSet<>();
//    users.add(user);
//
//    System.out.println(users.contains(user));
//    System.out.println(users.size());
//
//    user.incRating();
//
//    System.out.println(users.contains(user));
//    System.out.println(users.size());
  }
}


class User {

  final long id;
  String username;
  int rating;

  public User(long id, String username) {
    this.id = id;
    this.username = username;
  }

  public long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public int getRating() {
    return rating;
  }

  public int incRating() {
    return ++rating;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return id == user.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}