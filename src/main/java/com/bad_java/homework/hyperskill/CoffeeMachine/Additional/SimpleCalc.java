package com.bad_java.homework.hyperskill.CoffeeMachine.Additional;

import java.util.Scanner;

//  https://hyperskill.org/learn/step/2300

class SimpleCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll(" +", " ");
        String[] arrInput = input.split(" ");
        String operator = arrInput[1];

        long a = Long.parseLong(arrInput[0]);
        long b = Long.parseLong(arrInput[2]);

        switch (operator) {
            case "+": {
                System.out.println(a + b);
                break;
            }
            case "-": {
                System.out.println(a - b);
                break;
            }
            case "/": {
                if (b == 0) {
                    System.out.println("Division by 0!");
                } else {
                    System.out.println(a / b);
                }
                break;
            }
            case "*": {
                System.out.println(a * b);
                break;
            }
            default: {
                System.out.println("Unknown operator");
                break;
            }
        }
    }
}