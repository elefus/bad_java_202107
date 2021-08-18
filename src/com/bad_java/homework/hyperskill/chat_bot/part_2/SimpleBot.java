package com.bad_java.homework.hyperskill.chat_bot.part_2;

import java.util.Scanner;

public class SimpleBot {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Hello! My name is Art.");
    System.out.println("I was created in 2021.");
    System.out.println("Please, remind me your name.");

    // reading a name
    String yourName = scanner.next();
    System.out.println("What a great name you have, " + yourName + "!");
  }
}
