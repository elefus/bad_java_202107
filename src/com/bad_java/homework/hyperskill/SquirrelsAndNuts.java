package com.bad_java.homework.hyperskill;

import java.util.Scanner;

public class SquirrelsAndNuts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int squirrelsCount = scanner.nextInt();
        int nutsCount = scanner.nextInt();
        System.out.println(squirrelsCount % nutsCount);
    }
}
