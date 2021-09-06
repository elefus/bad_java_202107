package com.bad_java.homework.hyperskill.coffee_machine;

import java.util.Scanner;

import static java.lang.Math.min;

public class KeepTrackOfTheSuppliesPart5 {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        makingCoffee();
        ingredientCalculator();
        estimateTheNumberOfServings();
        buyFillTake();
    }

    public static void makingCoffee() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    public static void ingredientCalculator() {
        System.out.println("Write how many cups of coffee you will need:");
        int number_coffee = scanner.nextInt();
        System.out.println("For " + number_coffee + " cups of coffee you will need:");
        int water = number_coffee * 200;
        int milk = number_coffee * 50;
        int coffee_beans = number_coffee * 15;
        System.out.println(water +" ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee_beans + " g of coffee beans");
    }

    public static void estimateTheNumberOfServings() {
        System.out.println("Write how many ml of water the coffee machine has:");
        int water_machine = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk_machine = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans_machine = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int number_servings = scanner.nextInt();

        int number_water = water_machine / 200;
        int number_milk = milk_machine / 50;
        int number_beans = beans_machine / 15;
        int min_number = min(min(number_water, number_milk), number_beans);

        if (number_servings > min_number){
            System.out.println("No, I can make only " + min_number + " cup(s) of coffee");
        }
        else if (number_servings == min_number){
            System.out.println("Yes, I can make that amount of coffee ");
        }
        else{
            System.out.println("Yes, I can make that amount of coffee (and even " + (min_number - number_servings) + " more than that)");
        }
    }

    public static void buyFillTake(){
        int water_machine = 400;
        int milk_machine = 540;
        int beans_machine = 120;
        int cups_machine = 9;
        int money_machine = 550;
        int [] arr_machine = {water_machine, milk_machine, beans_machine, cups_machine, money_machine};

        while(true){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            switch (action){
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffee = scanner.next();
                    switch (coffee){

                        case "1":
                            espressoMethod(arr_machine);
                            break;

                        case "2":
                            latteMethod(arr_machine);
                            break;

                        case "3":
                            cappuccinoMethod(arr_machine);
                            break;

                        case "back":
                            break;

                        default:
                            System.out.println("Error!");
                            break;
                    }
                    break;

                case "fill":
                    fillMethod(arr_machine);
                    break;

                case "take":
                    takeMethod(arr_machine);
                    break;

                case "remaining":
                    resultCoffeeMachine(arr_machine);
                    break;

                case "exit":
                    return;

                default:
                    System.out.println("Error!");
                    break;
            }
        }
    }

    public static void takeMethod(int [] arr_machine){
        System.out.println("I gave you $" + arr_machine[4]);
        arr_machine[4] = 0;
    }

    public static void fillMethod(int [] arr_machine){
        System.out.println("Write how many ml of water you want to add:");
        int add_water = scanner.nextInt();
        arr_machine[0] += add_water;
        System.out.println("Write how many ml of milk you want to add:");
        int add_milk = scanner.nextInt();
        arr_machine[1] += add_milk;
        System.out.println("Write how many grams of coffee beans you want to add:");
        int add_beans = scanner.nextInt();
        arr_machine[2] += add_beans;
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int add_cups = scanner.nextInt();
        arr_machine[3] += add_cups;
    }

    public static void espressoMethod(int [] arr_machine){
        if(arr_machine[0] < 250){
            System.out.println("Sorry, not enough water!");
        }
        else if(arr_machine[2] < 16){
            System.out.println("Sorry, not enough coffee beans!");
        }
        else if(arr_machine[3] < 1){
            System.out.println("Sorry, not enough disposable cups!");
        }
        else{
            System.out.println("I have enough resources, making you a coffee!");
            arr_machine[0] -= 250;
            arr_machine[2] -= 16;
            arr_machine[3] -= 1;
            arr_machine[4] += 4;
        }
    }

    public static void latteMethod(int [] arr_machine){
        if(arr_machine[0] < 350){
            System.out.println("Sorry, not enough water!");
        }
        else if(arr_machine[1] < 75){
            System.out.println("Sorry, not enough milk!");
        }
        else if(arr_machine[2] < 20){
            System.out.println("Sorry, not enough coffee beans!");
        }
        else if(arr_machine[3] < 1){
            System.out.println("Sorry, not enough disposable cups!");
        }
        else{
            System.out.println("I have enough resources, making you a coffee!");
            arr_machine[0] -= 350;
            arr_machine[1] -= 75;
            arr_machine[2] -= 20;
            arr_machine[3] -= 1;
            arr_machine[4] += 7;
        }
    }

    public static void cappuccinoMethod(int [] arr_machine){
        if(arr_machine[0] < 200){
            System.out.println("Sorry, not enough water!");
        }
        else if(arr_machine[1] < 100){
            System.out.println("Sorry, not enough milk!");
        }
        else if(arr_machine[2] < 12){
            System.out.println("Sorry, not enough coffee beans!");
        }
        else if(arr_machine[3] < 1){
            System.out.println("Sorry, not enough disposable cups!");
        }
        else{
            System.out.println("I have enough resources, making you a coffee!");
            arr_machine[0] -= 200;
            arr_machine[1] -= 100;
            arr_machine[2] -= 12;
            arr_machine[3] -= 1;
            arr_machine[4] += 6;
        }
    }

    public static void resultCoffeeMachine(int [] arr_machine){
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(arr_machine[0] + " ml of water");
        System.out.println(arr_machine[1] + " ml of milk");
        System.out.println(arr_machine[2] + " g of coffee beans");
        System.out.println(arr_machine[3] + " disposable cups");
        System.out.println("$" + arr_machine[4] + " of money");
    }
}
