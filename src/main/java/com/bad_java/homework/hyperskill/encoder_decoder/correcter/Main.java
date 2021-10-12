package com.bad_java.homework.hyperskill.encoder_decoder.correcter;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.print("Write a mode:");
    String command = scanner.nextLine();

    TaskHandler taskHandler = new TaskHandler();

    switch (command) {
      case "encode":
        taskHandler.encodeFromTo("send.txt", "encoded.txt");
        break;

      case "send":
        taskHandler.sendFromTo("encoded.txt", "received.txt");
        break;

      case "decode":
        taskHandler.decodeFromTo("received.txt", "decoded.txt");
        break;
    }

  }
}



