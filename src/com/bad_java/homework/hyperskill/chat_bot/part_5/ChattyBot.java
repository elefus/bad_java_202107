package com.bad_java.homework.hyperskill.chat_bot.part_5;

import java.util.Scanner;

/**
 * @author Kirill Mololkin kir.mololkin@yandex.ru 06.08.2021
 */
public class ChattyBot {
	private final String name;
	private final int birthYear;
	private final Scanner scanner;

	public ChattyBot(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
		scanner = new Scanner(System.in);
	}

	public ChattyBot(String name, int birthYear, Scanner scanner) {
		this.name = name;
		this.birthYear = birthYear;
		this.scanner = scanner;
	}

	public String getName() {
		return name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void introduceYourself() {
		System.out.println("Hello! My name is " + name + ".");
		System.out.println("I was created in " + birthYear + ".");
	}

	public void greetUser() {
		System.out.println("Please, remind me your name.");
		String name = scanner.nextLine();
		System.out.println("What a great name you have, " + name + "!");
	}

	public void guessAge() {
		System.out.println("Let me guess your age.");
		System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

		int rem3 = scanner.nextInt();
		int rem5 = scanner.nextInt();
		int rem7 = scanner.nextInt();

		int age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
		System.out.println("Your age is " + age + "; that's a good time to start programming!");

	}

	public void count() {
		System.out.println("Now I will prove to you that I can count to any number you want.");
		int num = scanner.nextInt();
		for (int i = 0; i <= num; i++) {
			System.out.printf("%d!\n", i);
		}
	}

	public void test() {
		System.out.println("Let's test your programming knowledge.");
		System.out.println("Why do we use methods?");
		System.out.println("1. To repeat a statement multiple times.");
		System.out.println("2. To decompose a program into several small subroutines.");
		System.out.println("3. To determine the execution time of a program.");
		System.out.println("4. To interrupt the execution of a program.");

		while (true){
			int answerNumber = scanner.nextInt();

			if (answerNumber == 2) {
				break;
			} else {
				System.out.println("Please, try again.");
			}
		}
	}

	public void end() {
		System.out.println("Congratulations, have a nice day!"); // Do not change this text
	}
}
