package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2169

class HeathySleep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minSleep = Integer.valueOf(scanner.nextLine());
        int maxSleep = Integer.valueOf(scanner.nextLine());
        int sleep = Integer.valueOf(scanner.nextLine());

        if (sleep < minSleep) {
            System.out.println("Deficiency");
        } else if (sleep > maxSleep) {
            System.out.println("Excess");
        } else {
            System.out.println("Normal");
        }
    }
}