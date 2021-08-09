package com.bad_java.homework.hyperskill;

import java.util.Scanner;

public class HiringAChef {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.next();

        scanner.next();
        scanner.next();
        scanner.next();
        String cuisinePreference = scanner.next();
        System.out.printf(
            "The form for %s is completed. " +
                    "We will contact you if we need a chef " +
                    "that cooks %s dishes.",
            firstName,
            cuisinePreference
        );
    }
}
