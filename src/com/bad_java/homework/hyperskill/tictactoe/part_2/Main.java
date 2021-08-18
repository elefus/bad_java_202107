package com.bad_java.homework.hyperskill.tictactoe.part_2;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // write your code here
    System.out.print("Enter cells:");
    Scanner scanner = new Scanner(System.in);
    String inputString = scanner.nextLine();
    String outputString = "---------\n";
    for (int i = 0; i < inputString.length(); i++) {
      if (i % 3 == 0) {
        outputString += "| ";
      }
      outputString += Character.toString(inputString.charAt(i));
      if ((i + 1) % 3 == 0 && i != 0) {
        outputString += " |\n";
      } else {
        outputString += " ";
      }
    }
    outputString += "---------";
    System.out.print(outputString);
  }
}