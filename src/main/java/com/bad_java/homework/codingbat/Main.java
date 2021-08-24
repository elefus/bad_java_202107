package com.bad_java.homework.codingbat;

import java.util.Arrays;
import java.util.Scanner;
import com.bad_java.homework.codingbat.warmup1.Warmup1;
import com.bad_java.homework.codingbat.warmup2.Warmup2;
import com.bad_java.homework.codingbat.array1.Array1;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String userInput;
    do {
      System.out.print("Input command: ");
      userInput = in.nextLine();
      String[] tokens = userInput.split(", ");
      String command = tokens[0];
      switch (command) {
        case "exit":
          break;
        case "front3":
          System.out.println(Warmup1.front3(tokens[1]));
          break;
        case "array123":
          System.out.println(tokens[1]);
          String[] items = tokens[1].replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split("\\.");
          int[] results = new int[items.length];
          for (int i = 0; i < items.length; i++) {
            try {
              results[i] = Integer.parseInt(items[i]);
            } catch (NumberFormatException nfe) {
            };
          }
          Warmup2 war2 = new Warmup2();
          System.out.println(war2.array123(results));
          break;
        case "makePi":
          Array1 arr = new Array1();
          System.out.println(Arrays.toString(arr.makePi(Integer.parseInt(tokens[1]))));
          break;
        case "stringE":
          Warmup1 war = new Warmup1();
          System.out.println(war.stringE(tokens[1]));
          break;
        default:
          System.out.println(command);
          System.err.println("Provided unknown command, please try again");
          break;
      }
    } while (!userInput.equalsIgnoreCase("exit"));
    System.out.println("Program finished!");
  }
}













