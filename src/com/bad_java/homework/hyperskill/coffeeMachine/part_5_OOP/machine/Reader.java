package com.bad_java.homework.hyperskill.coffeeMachine.part_5_OOP.machine;

import java.util.Scanner;

abstract public class Reader {

  Scanner scanner = new Scanner(System.in);

  public String read(String output) {
    while (true) {
      System.out.println(output);
      String input = scanner.nextLine();
      if (check(input)) {
        return input;
      }
    }
  }

  abstract public boolean check(String input);
}

class CommandReader extends Reader {

  @Override
  public boolean check(String input) {
    if (input.intern() == "fill" || input.intern() == "buy" || input.intern() == "take" ||
        input.intern() == "remaining" || input.intern() == "exit") {
      return true;
    }
    return false;
  }
}

class QuantityReader extends Reader {

  @Override
  public boolean check(String input) {
    if (input.matches("\\d+")) {
      return true;
    }
    return false;
  }
}

class CoffeeReader extends Reader {

  @Override
  public boolean check(String input) {
    if (input.intern() == "1" || input.intern() == "2" ||
        input.intern() == "3" || input.intern() == "back") {
      return true;
    }
    return false;
  }
}