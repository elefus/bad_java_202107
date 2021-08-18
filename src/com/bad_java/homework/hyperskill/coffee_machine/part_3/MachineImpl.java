package com.bad_java.homework.hyperskill.coffee_machine.part_3;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Kirill Mololkin kir.mololkin@yandex.ru 10.08.2021
 */
public class MachineImpl implements Machine {

	private final PrintStream printWriter;
	private final Scanner scanner;
	private final Map<Ingredients, Integer> ingredientsInMachine;

	public MachineImpl(OutputStream outputStream, InputStream inputStream) {
		this.printWriter = new PrintStream(outputStream);
		this.scanner = new Scanner(inputStream);
		this.ingredientsInMachine = new HashMap<>(Map.of(Ingredients.MILK, 0, Ingredients.WATER,
				0, Ingredients.BEANS, 0));
	}

	public MachineImpl(InputStream inputStream) {
		this(System.out, System.in);
	}

	public MachineImpl(OutputStream outputStream) {
		this(outputStream, System.in);
	}

	public MachineImpl() {
		this(System.out, System.in);
	}

	@Override
	public void makeCoffee() {
		printWriter.println("Starting to make a coffee");
		printWriter.println("Grinding coffee beans");
		printWriter.println("Boiling water");
		printWriter.println("Mixing boiled water with crushed coffee beans");
		printWriter.println("Pouring coffee into the cup");
		printWriter.println("Pouring some milk into the cup");
		printWriter.println("Coffee is ready!");
	}

	@Override
	public void calculateIngredients() {
		printWriter.println("Write how many cups of coffee you will need: ");
		int cups = scanner.nextInt();
		printWriter.printf("For %d cups of coffee you will need:%n", cups);
		Map<Ingredients, Integer> ingredientsAmount = calculateIngredientsAmount(cups);
		printWriter.printf("%d ml of water%n", ingredientsAmount.get(Ingredients.WATER));
		printWriter.printf("%d ml of milk%n", ingredientsAmount.get(Ingredients.MILK));
		printWriter.printf("%d g of coffee beans%n", ingredientsAmount.get(Ingredients.BEANS));

	}

	@Override
	public void loadIngredientsAndCalculateCups() {
		loadIngredients();
		printWriter.println("Write how many cups of coffee you will need:");
		int requiredCups = scanner.nextInt();
		int availableCups = calculateAvailableCups();

		if (requiredCups == availableCups) {
			printWriter.println("Yes, I can make that amount of coffee");
		} else if (requiredCups > availableCups) {
			printWriter.printf("No, I can make only %d cup(s) of coffee", availableCups);
		} else {
			printWriter.printf("Yes, I can make that amount of coffee (and even %d more than that)",
					availableCups - requiredCups);
		}

	}

	private void loadIngredients() {
		printWriter.println("Write how many ml of water the coffee machine has: ");
		ingredientsInMachine.put(Ingredients.WATER, scanner.nextInt());
		printWriter.println("Write how many ml of milk the coffee machine has: ");
		ingredientsInMachine.put(Ingredients.MILK, scanner.nextInt());
		printWriter.println("Write how many grams of coffee beans the coffee machine has: ");
		ingredientsInMachine.put(Ingredients.BEANS, scanner.nextInt());
	}

	private int calculateAvailableCups() {
		int waterForCups = ingredientsInMachine.get(Ingredients.WATER) / 200;
		int milkForCups = ingredientsInMachine.get(Ingredients.MILK) / 50;
		int beansForCups = ingredientsInMachine.get(Ingredients.BEANS) / 15;

		return minOfThree(waterForCups, milkForCups, beansForCups);
	}

	private int minOfThree(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

	private Map<Ingredients, Integer> calculateIngredientsAmount(int cups) {
		return Map.of(Ingredients.WATER, 200 * cups, Ingredients.MILK,
				50 * cups, Ingredients.BEANS, 15 * cups);
	}

	public enum Ingredients {
		MILK("ml"),
		WATER("ml"),
		BEANS("grams");

		private final String measure;
		Ingredients(String measure) {
			this.measure = measure;
		}

		public String getMeasure() {
			return measure;
		}
	}
}
