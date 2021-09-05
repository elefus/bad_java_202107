package com.bad_java.lectures._01;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ControlFlowConstructions {

    public static void main(String[] args) {
//        if (tmp()) return;

//        System.out.println("Before while");
//        do {
//            System.out.println("start");
//            if (ThreadLocalRandom.current().nextBoolean()) {
//                break;
//            }
//            System.out.println("finish");
//        } while (true);
//        System.out.println("After while");

//        for (int i = 0; i < 10; i++) {
//            if (i % 2 == 0) {
//                continue;
//            }
//            System.out.println(i);
//        }

        System.out.println("Provided args: ");
        for (String arg : args) {
            System.out.println(arg);
        }

//        for (int i = 0; i < args.length; i++) {
//            System.out.println(i + " " + args[i]);
//        }


        int sum = getSum();
        System.out.println(sum);

        System.out.println("finish");
    }

    private static int getSum() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (sum > 56) {
                    return sum;
                }
                sum += i * j;
            }
        }
        return sum;
    }

    private static boolean tmp() {
        {
            int a = 0;
            System.out.println(a);
        }
        {
            int a = 1;
            System.out.println(a);
        }
//        System.out.println(a);

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean isExit = input.equals("exit");
//        if (isExit || expression1 && expression2 && (expression3 || expression4)) { // code conventions
        if (isExit) {
            System.out.println("exit");
            return true;
        } else if (input.equals("pause")) {
            System.out.println("pause");
        } else {
            System.out.println("other");
        }

        System.out.println(randomBoolean());
        System.out.println(randomBoolean());
        System.out.println(randomBoolean());

        if (randomBoolean()) {
            if (randomInt() > 30) {
                System.out.println("wtf");
            } else {
                System.out.println("Hello");
            }
        }

        /*
         * byte
         * short
         * int
         * char
         * String
         * enum
         */
        final String command = "qwe";

        String userInput = scanner.nextLine();
        switch (userInput) {
            case command:
                System.out.println("command");


            case "exit":
                return true;

            case "pause":
            case "пауза":
            case "p": {
                int x = 10;

                System.out.println("pause");
                // .. pause()
                break;
            }

            case "hello": {
                int x = 30;
                System.out.println("Hello!");
                break;
            }

            default:
                System.out.println("Default behaviour");
        }

        int x = 0;
        switch (x) {
            case 1:
            case 2:
            case 3:
            case 4:
        }


        int upperBound = scanner.nextInt();
        int sum = 0;
        while (upperBound != 0) {
            sum += upperBound;
            upperBound--;
        }
        System.out.println(sum);
        return false;
    }

    private static boolean randomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    private static int randomInt() {
        return ThreadLocalRandom.current().nextInt();
    }
}
