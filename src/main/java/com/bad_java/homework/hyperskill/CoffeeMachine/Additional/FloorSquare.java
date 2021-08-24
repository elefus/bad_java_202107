package com.bad_java.homework.hyperskill.CoffeeMachine.Additional;

import java.util.Scanner;

//  https://hyperskill.org/learn/step/2300

class FloorSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double a;
        double b;
        double c;
        double square;


        switch (input){
            case "triangle": {
                a = Integer.parseInt(scanner.nextLine());
                b = Integer.parseInt(scanner.nextLine());
                c = Integer.parseInt(scanner.nextLine());
                //полупериметр
                double p = (a + b + c) / 2.0d;
                square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                System.out.println(square);
                break;
            }
            case "rectangle": {
                a = Integer.parseInt(scanner.nextLine());
                b = Integer.parseInt(scanner.nextLine());
                square = a * b;
                System.out.println(square);
                break;
            }
            case "circle": {
                a = Integer.parseInt(scanner.nextLine());
                square = 3.14d * Math.pow(a, 2);
                System.out.println(square);
                break;
            }
            default: {
                System.out.println("Unknown operator");
                break;
            }
        }
    }
}