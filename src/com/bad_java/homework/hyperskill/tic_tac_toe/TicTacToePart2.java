package com.bad_java.homework.hyperskill.tic_tac_toe;

import java.util.Scanner;

public class TicTacToePart2 {

  final static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Enter cells: ");
    String word = scanner.next();
    String[] arr = word.split("");
    displayField(arr);
  }

  public static void displayField(String[] arr) {
    System.out.println("---------");
    System.out.printf("| %s %s %s |%n", arr[0], arr[1], arr[2]);
    System.out.printf("| %s %s %s |%n", arr[3], arr[4], arr[5]);
    System.out.printf("| %s %s %s |%n", arr[6], arr[7], arr[8]);
    System.out.println("---------");
  }
}
