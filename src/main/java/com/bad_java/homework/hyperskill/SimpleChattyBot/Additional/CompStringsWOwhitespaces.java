package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2721

class CompStringsWOwhitespaces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        String[] input1arr = input1.split(" ");
        String[] input2arr = input2.split(" ");

        input1 = "";
        input2 = "";

        for (String s : input1arr) {
            if (!s.equals("")) {
                input1 += s;
            }
        }
        for (String s : input2arr) {
            if (!s.equals("")) {
                input2 += s;
            }
        }
        System.out.println(input1.equals(input2));
    }
}