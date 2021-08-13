package com.bad_java.homework.hyperskill.coffee_machine.stage1;

import java.util.Scanner;



public class CoffeeMachine {
    public static void main(String[] args) {
        final int WATER_PER_CUP = 200;
        final int MILK_PER_CUP = 50;
        final int COFFEE_PER_CUP = 15;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int desiredCups = scanner.nextInt();

        int a = water / WATER_PER_CUP;
        int b = milk / MILK_PER_CUP;
        int c = coffee / COFFEE_PER_CUP;

        int totalCups = (a<b) ? ((a<c) ? a : c) : ((b<c) ? b : c);

        if (totalCups == desiredCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (totalCups > desiredCups) {
            int extraCups = totalCups - desiredCups;
            System.out.println("Yes, I can make that amount of coffee " +
                    "(and even " + (extraCups) + " more than that)");
        } else {
            System.out.println("No, I can make only" + totalCups + "cup(s) of coffee");
        }
    }
}



