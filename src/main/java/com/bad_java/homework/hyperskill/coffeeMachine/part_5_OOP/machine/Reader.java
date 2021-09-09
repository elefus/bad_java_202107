package com.bad_java.homework.hyperskill.coffeeMachine.part_5_OOP.machine;

import java.util.Scanner;

abstract public class Reader {

  Scanner scanner = new Scanner(System.in);

  public String printStringAndReadInput(String output) {
    while (true) {
      System.out.println(output);
      String input = scanner.nextLine();
      if (checkString(input)) {
        return input;
      }
    }
  }

  abstract public boolean checkString(String input);
}

class CommandReader extends Reader {

  @Override
  public boolean checkString(String input) {
    return input.equals("fill") || input.equals("buy") || input.equals("take") ||
        input.equals("remaining") || input.equals("exit");
  }
}

class QuantityReader extends Reader {

  @Override
  public boolean checkString(String input) {
    return input.matches("\\d+");
  }
}

class CoffeeReader extends Reader {

  @Override
  public boolean checkString(String input) {
    return (input.equals("1") || input.equals("2") ||
        input.equals("3") || input.equals("back"));
  }
}

