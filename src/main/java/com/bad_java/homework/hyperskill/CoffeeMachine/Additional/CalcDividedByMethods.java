package com.bad_java.homework.hyperskill.CoffeeMachine.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/10576

class CalcDividedByMethods {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll(" +", " ");
        String[] arrInput = input.split(" ");
        String operator = arrInput[1];

        long a = Long.parseLong(arrInput[0]);
        long b = Long.parseLong(arrInput[2]);

        switch (operator) {
            case "+": {
                sumTwoNumbers(a, b);
                break;
            }
            case "-": {
                subtractTwoNumbers(a, b);
                break;
            }
            case "/": {
                divideTwoNumbers(a, b);
                break;
            }
            case "*": {
                multiplyTwoNumbers(a, b);
                break;
            }
            default: {
                System.out.println("Unknown operator");
                break;
            }
        }
    }
    public static void subtractTwoNumbers(long a, long b) {
        System.out.println(a - b);
    }


    public static void sumTwoNumbers(long a, long b) {
        System.out.println(a + b);
    }


    public static void divideTwoNumbers(long a, long b) {
        if (b == 0) {
            System.out.println("Division by 0!");
        } else {
            System.out.println(a / b);
        }
    }


    public static void multiplyTwoNumbers(long a, long b) {
        System.out.println(a * b);
    }
}