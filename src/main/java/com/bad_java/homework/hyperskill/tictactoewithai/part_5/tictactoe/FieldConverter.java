package com.bad_java.homework.hyperskill.tictactoewithai.part_5.tictactoe;

public class FieldConverter {

  public String convertRawFieldToVisibleTable(String rawField) {
    String fieldToConvert = rawField.replaceAll("_", " ");

    String firstLine = "---------\n";

    String secondLine = String.format(
        "| %c %c %c |%n",
        fieldToConvert.charAt(0),
        fieldToConvert.charAt(1),
        fieldToConvert.charAt(2));

    String thirdLine = String.format(
        "| %c %c %c |%n",
        fieldToConvert.charAt(3),
        fieldToConvert.charAt(4),
        fieldToConvert.charAt(5));

    String fourthLine = String.format(
        "| %c %c %c |%n",
        fieldToConvert.charAt(6),
        fieldToConvert.charAt(7),
        fieldToConvert.charAt(8));

    String fifthLine = "---------\n";

    return firstLine + secondLine + thirdLine + fourthLine + fifthLine;
  }
}
