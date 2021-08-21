package com.bad_java.homework.hyperskill.chat_bot.part_5;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SimpleBot {
    final static private Scanner scanner = new Scanner(System.in);
    final static private String BOT_NAME = "SimpleJavaBot";
    final static private int BOT_AGE = 2021;
    final static private int MISTAKE_COUNT = 5;
    final static private int QUESTION_COUNT = 4;

    public static void main(String[] args) {

        greet();
        askUserName();
        guessAge();
        count();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test();
        end();
    }

    static private int takeInt() {
        System.out.print("Please enter integer value:\n");
        if (!scanner.hasNextInt()) {
            System.out.print("That's not integer value. Please try again.\n");
            scanner.next();
            return takeInt();
        }
        //System.out.print("That's integer value. You are amazing.\n");
        return scanner.nextInt();
    }

    static private void greet() {
        System.out.printf("Hello! My name is %s.\n", BOT_NAME);
        System.out.printf("I was created in %d.\n", BOT_AGE);
    }

    static private void askUserName() {
        System.out.println("Please, remind me your name.");
        String name = scanner.nextLine();
        System.out.printf("What a great name you have, %s!\n", name);
    }

    static private void guessAge() {
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        int remainder3 = takeInt();
        int remainder5 = takeInt();
        int remainder7 = takeInt();

        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        System.out.printf("Your age is %d; that's a good time to start programming!\n", age);
    }

    static private void count() {
        System.out.println("Now I will prove to you that I can count to any number you want.");

        int userNumber = takeInt();
        for (int i = 0; i <= userNumber; i++) {
            System.out.printf("%d!\n", i);
        }
    }

    static private void end() {
        System.out.println("Congratulations, you are almost senior java developer, have a nice day!");
    }

    static private void test() {
        System.out.println("Let's test your programming knowledge.");

        Random rand = new Random();
        int anotherOne;
        do {
            int questionNumber = rand.nextInt(QUESTION_COUNT) + 1;
            System.out.printf("You only have %d attempts.\n", MISTAKE_COUNT);
            int ans = test(questionNumber);
            int numOfWrongAns = 0;
            int userAns;

            do {
                userAns = takeInt();
                if (userAns != ans) {
                    System.out.println("This is incorrect answer. Please, try again.");
                    numOfWrongAns++;
                } else {
                    System.out.println("Correct.\nGreat job!");
                }
                if (numOfWrongAns > MISTAKE_COUNT) {
                    System.out.println("There are too many wrong answers. Are you sure you've read the theory?\n");
                    break;
                }
            } while (userAns != ans);

            System.out.println("If you want another question enter any integer value. 0 - exit from program.");
            anotherOne = takeInt();

        } while (anotherOne != 0);
    }

    static private int test(int i) {
        int ans;
        switch (i) {
            default:
            case 1:
                System.out.print("What is the correct general syntax of the ternary operator?\n");
                System.out.print("Select one option from the list and write the number of the answer.\n");
                System.out.print("\t1. if condition ? trueCase else elseCase.\n");
                System.out.print("\t2. condition ? trueCase : elseCase.\n");
                System.out.print("\t3. trueCase : elseCase ? condition.\n");
                System.out.print("\t4. if condition ? trueCase : elseCase.\n");
                ans = 2;
                break;
            case 2:
                System.out.print("Given the following code with the ternary conditional operator.\n");
                System.out.print("\tint result = a > b ? (a > c ? a : c) : (b > c ? b : c);.\n");
                System.out.print("What does this code do?\n");
                System.out.print("Select one option from the list and write the number of the answer.\n");
                System.out.print("\t1. It can't be compiled because nested ternary operators are forbidden.\n");
                System.out.print("\t2. It finds min of three numbers.\n");
                System.out.print("\t3. If a > b it finds min of three numbers else max of them.\n");
                System.out.print("\t4. It finds max of three numbers.\n");
                System.out.print("\t5. If a > b it finds max of three numbers else min of them.\n");
                ans = 4;
                break;
            case 3:
                System.out.print("Select an incorrect literal.\n");
                System.out.print("Select one option from the list and write the number of the answer.\n");
                System.out.print("\t1. \"123456\"\n");
                System.out.print("\t2. '@'\n");
                System.out.print("\t3. 'abc'\n");
                System.out.print("\t4. \"e-mail@gmail.com\"\n");
                System.out.print("\t5. 1806\n");
                ans = 3;
                break;
            case 4:
                System.out.print("What does the code print?\n");
                System.out.print("\tint i = 0;\n");
                System.out.print("\tfor (int k = 0; k < 100; k++) {\n");
                System.out.print("\t\ti = i++;\n");
                System.out.print("\t}\n");
                System.out.print("Select one option from the list and write the number of the answer.\n");
                System.out.print("\t1. It can't be compiled.\n");
                System.out.print("\t2. 99\n");
                System.out.print("\t3. 100\n");
                System.out.print("\t4. 101\n");
                System.out.print("\t5. 0\n");
                ans = 5;
                break;
        }
        return ans;
    }
}