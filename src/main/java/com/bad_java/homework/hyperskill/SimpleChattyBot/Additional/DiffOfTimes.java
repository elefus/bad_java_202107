package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2218

class DiffOfTimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startHour = Integer.valueOf(scanner.nextLine());
        int startMinutes = Integer.valueOf(scanner.nextLine());
        int startSeconds = Integer.valueOf(scanner.nextLine());
        int endHours = Integer.valueOf(scanner.nextLine());
        int endMinutes = Integer.valueOf(scanner.nextLine());
        int endSeconds = Integer.valueOf(scanner.nextLine());

        System.out.println(
            (endHours * 3600 + endMinutes * 60 + endSeconds - startHour * 3600 - startMinutes * 60
                - startSeconds));
    }
}