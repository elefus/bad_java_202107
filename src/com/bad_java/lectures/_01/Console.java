package com.bad_java.lectures._01;

import java.util.Scanner;

public class Console {

    //    public static void main(String...args) {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("No config file was provided!");
            return;
        } else {
            System.out.println("Was provided " + args.length + " arguments");
        }

        System.out.println("Provided config file: " + args[0]);

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        System.out.println("User provided a string: " + userInput);

        System.out.printf("%.3f %s %d%n", 1.234566, "string", 10);
        System.err.println("System error");
    }
}
