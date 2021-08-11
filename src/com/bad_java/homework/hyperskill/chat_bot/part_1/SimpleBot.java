package com.bad_java.homework.hyperskill.chat_bot.part_1;

import java.util.Scanner;

public class SimpleBot {
    static private final String NAME = "Jake";
    static private final String DATE_OF_BIRTH = "August 5, 2021";
    private static final Scanner inputFromConsole = new Scanner(System.in);

    public static class SimpleBotAcquaintance {
        public static void sayHello () {
            System.out.printf("Hello! My name is %s.\n", NAME);
        }
        public static void sayDateOfBirthday () {
            System.out.printf("I was created in %s.\n", DATE_OF_BIRTH);
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
        private int checkRemainder(int remainder, int divider) {
            if(remainder < 0 || remainder > divider - 1){
                System.out.println("It can't be a reminder of dividing your age by 7. " +
                        "We will calculate new one based on your input");
                remainder %= divider;
            }
            return remainder;
        }
        public void greetingUser(String name) {
            System.out.println("What a great name you have, " + name + "!");
        }
}
