package com.bad_java.homework.hyperskill.SimpleChattyBot.Additional;

import java.util.Scanner;

//https://hyperskill.org/learn/step/2168

class Queen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().replaceAll(" +", " ");
        String[] arrInput = input.split(" ");
        if (arrInput.length < 4) {
            System.out.println(false);
        } else {
            int x1 = Integer.parseInt(arrInput[0]);
            int y1 = Integer.parseInt(arrInput[1]);
            int x2 = Integer.parseInt(arrInput[2]);
            int y2 = Integer.parseInt(arrInput[3]);

            float isDiag = Math.abs((float)(x1 - x2) / (y1 - y2));

            //System.out.println(isDiag);

            if (x1 == x2 || y1 == y2 || isDiag == 1.0f) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}