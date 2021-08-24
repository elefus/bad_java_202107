package com.bad_java.homework.hyperskill.CoffeeMachine.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2265

public class PrepFullName {

    public static String prepareFullName(String firstName, String lastName) {
        if (firstName == null) {
            return lastName;
        } else if (lastName == null) {
            return firstName;
        } else {
            return firstName + " " + lastName;
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        firstName = "null".equals(firstName) ? null : firstName;

        String lastName = scanner.nextLine();
        lastName = "null".equals(lastName) ? null : lastName;

        System.out.println(prepareFullName(firstName, lastName));
    }
}