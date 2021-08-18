package com.bad_java.homework.hyperskill.chat_bot.part_3;

import java.util.Scanner;

public class SimpleBot {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Hello! My name is Aid.");
    System.out.println("I was created in 2021.");
    System.out.println("Please, remind me your name.");

    String name = scanner.nextLine();

    System.out.println("What a great name you have, " + name + "!");
    System.out.println("Let me guess your age.");
    System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

    // reading all remainders
    int dividingByThree = scanner.nextInt();
    int dividingByFive = scanner.nextInt();
    int dividingBySeven = scanner.nextInt();
    int yourAge = 0;
    while (true){
      if (yourAge % 3 == dividingByThree &&
          yourAge % 5 == dividingByFive &&
          yourAge % 7 == dividingBySeven) break;
      yourAge++;
    }
    System.out.println("Your age is " + yourAge + "; that's a good time to start programming!");
  }
}