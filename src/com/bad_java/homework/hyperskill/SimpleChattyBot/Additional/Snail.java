package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2221

class Snail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = Integer.valueOf(scanner.nextLine());
        int feetUpPerDay = Integer.valueOf(scanner.nextLine());
        int feetDownPerNight = Integer.valueOf(scanner.nextLine());
        int sumFeet = 0;
        int daysToTopPole = 0;

        while (sumFeet < height) {
            sumFeet += feetUpPerDay;
            if (sumFeet >= height) {
                break;
            }
            sumFeet -= feetDownPerNight;
            daysToTopPole++;
        }
        System.out.println(++daysToTopPole);
    }
}