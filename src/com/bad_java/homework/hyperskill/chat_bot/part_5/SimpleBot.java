package com.bad_java.homework.hyperskill.chat_bot.part_5;

import java.util.Scanner;

public class SimpleBot {
    static private final String NAME = "Jake";
    static private final String DATE_OF_BIRTH = "August 5, 2021";
    private static final Scanner inputFromConsole = new Scanner(System.in);

    public static class SimpleBotAcquaintance {
        public static void sayHello() {
            System.out.printf("Hello! My name is %s.%n", NAME);
        }

        public static void sayDateOfBirthday() {
            System.out.printf("I was created in %s.%n", DATE_OF_BIRTH);
        }
    }

    public User registerUser() {
        return new User(askingUserName(), guessingAge());
    }

    public String askingUserName() {
        System.out.println("Please, remind me your name.");
        String name = inputFromConsole.nextLine();
        greetingUser(name);
        return name;
    }

    public int guessingAge() {
        System.out.println("Let me guess your name");
        System.out.println("Enter remainder of dividing your age by 3");
        int remainder3 = checkRemainder(inputFromConsole.nextInt(), 3);

        System.out.println("Enter remainder of dividing your age by 5");
        int remainder5 = checkRemainder(inputFromConsole.nextInt(), 5);

        System.out.println("Enter remainder of dividing your age by 7");
        int remainder7 = checkRemainder(inputFromConsole.nextInt(), 7);

        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        System.out.println("Your age is " + age + "; that's a good time to start programming!");
        return age;
    }

    public void counting() {
        System.out.println("Now I will prove to you that I can count to any number you want.%n Input a number? please");
        int numberToCountTo = inputFromConsole.nextInt() + 1;
        for (int i = 0; i < numberToCountTo; i++) {
            System.out.println(i + "!");
        }
        System.out.println("Completed, have a nice day!");
    }

    private int checkRemainder(int remainder, int divider) {
        if (remainder < 0 || remainder > divider - 1) {
            System.out.println("It can't be a reminder of dividing your age by 7. " +
                    "We will calculate new one based on your input");
            remainder %= divider;
        }
        return remainder;
    }

    public void test() {
        System.out.println("Let's test your programming knowledge.");
        for (Answers cur : Answers.values()) {
            System.out.println(cur.toString());
        }

        int answer = inputFromConsole.nextInt();

        while (!Answers.getByCode(answer)) {
            System.out.println("Please, try again.");
            answer = inputFromConsole.nextInt();
        }

    }

    public void greetingUser(String name) {
        System.out.println("What a great name you have, " + name + "!");
    }

    public void end() {
        System.out.println("Congratulations, have a nice day!");
    }
    
}

enum Answers {
    INCORRECT1(1, false, "1. To repeat a statement multiple times."),
    CORRECT(2, true, "2. To decompose a program into several small subroutines."),
    INCORRECT3(3, false, "3. To determine the execution time of a program."),
    INCORRECT4(4, false, "4. To interrupt the execution of a program.");

    Answers(int number, boolean isTrue, String statement) {
        this.number = number;
        this.isTrue = isTrue;
        this.statement = statement;
    }

    public int getNumber() {
        return number;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public static boolean getByCode(int number) {
        for (Answers curAnswer : Answers.values()) {
            if (curAnswer.getNumber() == number) {
                return curAnswer.isTrue;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return statement;
    }

    private final int number;
    private final boolean isTrue;
    private final String statement;

}
