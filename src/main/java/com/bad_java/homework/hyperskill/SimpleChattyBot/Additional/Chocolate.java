package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2170

class Chocolate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthBar = Integer.valueOf(scanner.nextLine());
        int widthBar = Integer.valueOf(scanner.nextLine());
        int countBits = Integer.valueOf(scanner.nextLine());

        if ((countBits % lengthBar == 0
            && countBits / lengthBar <= widthBar)
            || (countBits % widthBar == 0
            && countBits / widthBar <= lengthBar)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}