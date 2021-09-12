package com.bad_java.homework.hyperskill.tictactoeWithAI.part_5.tictactoe;

public class FieldConverter {

  public String convertFieldToVisibleTable(String field) {
    String fieldToConvert = field.replaceAll("_", " ");

    String firstString = "---------\n";

    String secondString = String.format(
        "| %c %c %c |%n",
        fieldToConvert.charAt(0),
        fieldToConvert.charAt(1),
        fieldToConvert.charAt(2));

    String thirdString = String.format(
        "| %c %c %c |%n",
        fieldToConvert.charAt(3),
        fieldToConvert.charAt(4),
        fieldToConvert.charAt(5));

    String fourthString = String.format(
        "| %c %c %c |%n",
        fieldToConvert.charAt(6),
        fieldToConvert.charAt(7),
        fieldToConvert.charAt(8));

    String fifthString = "---------\n";

    return firstString + secondString + thirdString + fourthString + fifthString;
  }
}
