package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2167

class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        boolean isLeap = input % 4 == 0 && input % 100 != 0;
        if (input % 400 == 0) {
            isLeap = true;
        }
        if (isLeap) {
            System.out.println("Leap");
        } else {
            System.out.println("Regular");
        }
    }
}