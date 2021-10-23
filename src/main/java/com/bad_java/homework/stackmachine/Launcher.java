package com.bad_java.homework.stackmachine;

import java.util.Scanner;

/**
 * @author Kirill Mololkin Kirill-mol 23.10.2021
 */
public class Launcher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution solution = new Solution();

		System.out.println(solution.solution(sc.nextLine()));
	}
}

//13 DUP 4 POP 5 DUP + DUP + -


