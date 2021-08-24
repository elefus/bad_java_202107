package com.bad_java.homework.hyperskill.CoffeeMachine.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/10992

public class PosOfMax {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int a = scanner.nextInt();
        final int b = scanner.nextInt();
        final int c = scanner.nextInt();

        System.out.println(getNumberOfMaxParam(a, b, c));
    }

    public static int getNumberOfMaxParam(int a, int b, int c) {
        return a >= b && a >= c
            ? 1
            : b >= c && b >= a
                ? 2
                : 3;
    }
}