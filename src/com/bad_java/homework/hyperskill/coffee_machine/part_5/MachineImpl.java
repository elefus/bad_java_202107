package com.bad_java.homework.hyperskill.coffee_machine.part_5;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Kirill Mololkin Kirill-mol 10.08.2021
 */
public class MachineImpl implements Machine {

	private final PrintStream printWriter;
	private final Scanner scanner;
	private final Map<Ingredients, Integer> ingredientsInMachine;

	public MachineImpl(OutputStream outputStream, InputStream inputStream) {
		this.printWriter = new PrintStream(outputStream);
		this.scanner = new Scanner(inputStream);
		this.ingredientsInMachine = new HashMap<>(Map.of(
				Ingredients.WATER, 400,
				Ingredients.MILK, 540,
				Ingredients.BEANS, 120,
				Ingredients.CUPS, 9,
				Ingredients.MONEY, 550));
	}

	public MachineImpl(InputStream inputStream) {
		this(System.out, inputStream);
	}

	public MachineImpl(OutputStream outputStream) {
		this(outputStream, System.in);
	}

	public MachineImpl() {
		this(System.out, System.in);
	}

	private void increaseValueOfOneIngredient(Ingredients ingredient, int value) {
		ingredientsInMachine.put(ingredient, ingredientsInMachine.get(ingredient) + value);
	}

	private void decreaseValueOfOneIngredient(Ingredients ingredient, int value) {
		if (value > ingredientsInMachine.get(ingredient)) {
			throw new RuntimeException(String.format("Not enough ingredient %s in machine current - %d, need - %d ",
					ingredient.toString(),
					ingredientsInMachine.get(ingredient),
					value));
		}

		ingredientsInMachine.put(ingredient, ingredientsInMachine.get(ingredient) - value);
	}

	private void loadIngredients() {
		printWriter.println("Write how many ml of water you want to add:");
		increaseValueOfOneIngredient(Ingredients.WATER, Integer.parseInt(scanner.nextLine()));

		printWriter.println("Write how many ml of milk you want to add:");
		increaseValueOfOneIngredient(Ingredients.MILK, Integer.parseInt(scanner.nextLine()));

		printWriter.println("Write how many grams of coffee beans you want to add:");
		increaseValueOfOneIngredient(Ingredients.BEANS, Integer.parseInt(scanner.nextLine()));

		printWriter.println("Write how many disposable cups of coffee you want to add:");
		increaseValueOfOneIngredient(Ingredients.CUPS, Integer.parseInt(scanner.nextLine()));

	}

	private void printIngredientsInMachine() {
		System.out.println("The coffee machine has:");
		System.out.printf("%d ml of water%n", ingredientsInMachine.get(Ingredients.WATER));
		System.out.printf("%d ml of milk%n", ingredientsInMachine.get(Ingredients.MILK));
		System.out.printf("%d g of coffee beans%n", ingredientsInMachine.get(Ingredients.BEANS));
		System.out.printf("%d disposable cups%n", ingredientsInMachine.get(Ingredients.CUPS));
		System.out.printf("$%d of money%n", ingredientsInMachine.get(Ingredients.MONEY));
	}

	private void takeMoneyFromMachine() {
		printWriter.printf("I gave you $%d%n", ingredientsInMachine.get(Ingredients.MONEY));
		ingredientsInMachine.put(Ingredients.MONEY, 0);
	}

	private Action chooseAction() {
		printWriter.println("Write action (buy, fill, take, remaining, exit):");
		Action action = null;

		while (action == null) {
			try {
				action = Action.valueOf(scanner.nextLine().toUpperCase());
			} catch (IllegalArgumentException e) {
				System.out.println("No such action");
				System.out.println("Write action again");
			}
		}
		System.out.println();
		return action;
	}

	private void createCoffee(CoffeeType coffeeType) {
		if (ingredientsInMachine.get(Ingredients.WATER) < coffeeType.getWaterMills()) {
			printWriter.println("Sorry, not enough water!");
		} else if (ingredientsInMachine.get(Ingredients.MILK) < coffeeType.getMilkMills()) {
			printWriter.println("Sorry, not enough milk!");
		} else if (ingredientsInMachine.get(Ingredients.BEANS) < coffeeType.getBeansGrams()) {
			printWriter.println("Sorry, not enough coffee beans!");
		} else if (ingredientsInMachine.get(Ingredients.CUPS) < 1) {
			printWriter.println("Sorry, not enough disposable cups!");
		} else {

			printWriter.println("I have enough resources, making you a coffee!");

			decreaseValueOfOneIngredient(Ingredients.WATER, coffeeType.getWaterMills());
			decreaseValueOfOneIngredient(Ingredients.MILK, coffeeType.getMilkMills());
			decreaseValueOfOneIngredient(Ingredients.BEANS, coffeeType.getBeansGrams());
			decreaseValueOfOneIngredient(Ingredients.CUPS, 1);

			increaseValueOfOneIngredient(Ingredients.MONEY, coffeeType.getPrice());
		}
	}

	private int chooseCoffeeType() {
		int coffeeTypeNumber = 0;

		while (coffeeTypeNumber == 0) {
			try {
				String chosenCoffee = scanner.nextLine();
				if (chosenCoffee.equals("back")) {
					return -1;
				} else {
					coffeeTypeNumber = Integer.parseInt(chosenCoffee);
				}
				if (coffeeTypeNumber < 1 || coffeeTypeNumber > 3) {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				coffeeTypeNumber = 0;
				System.out.println("No such coffee type");
				System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
			}
		}

		return coffeeTypeNumber;
	}

	private void buyCoffee() {
		printWriter.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");

		int coffeeTypeNumber = chooseCoffeeType();

		if (coffeeTypeNumber != -1) {
			createCoffee(CoffeeType.getByNumber(coffeeTypeNumber));
		}

	}

	@Override
	public void run() {
		Action action = chooseAction();

		while (!action.equals(Action.EXIT)) {

			switch (action) {
				case BUY:
					buyCoffee();
					break;
				case FILL:
					loadIngredients();
					break;
				case TAKE:
					takeMoneyFromMachine();
					break;
				case REMAINING:
					printIngredientsInMachine();
					break;
			}
			System.out.println();
			action = chooseAction();
		}

	}

	private enum Ingredients {
		MILK("ml"),
		WATER("ml"),
		BEANS("grams"),
		CUPS("number"),
		MONEY("dollars");

		private final String measure;

		Ingredients(String measure) {
			this.measure = measure;
		}

		public String getMeasure() {
			return measure;
		}
	}

	private enum CoffeeType {
		ESPRESSO(250, 0, 16, 1, 4),
		LATTE(350, 75, 20, 2, 7),
		CAPPUCCINO(200, 100, 12, 3, 6);

		private final int waterMills;
		private final int milkMills;
		private final int beansGrams;
		private final int cupsNumber;
		private final int price;

		CoffeeType(int waterMills, int milkMills, int beansGrams, int cupsNumber, int price) {
			this.waterMills = waterMills;
			this.milkMills = milkMills;
			this.beansGrams = beansGrams;
			this.cupsNumber = cupsNumber;
			this.price = price;
		}

		public int getCupsNumber() {
			return cupsNumber;
		}

		public int getWaterMills() {
			return waterMills;
		}

		public int getMilkMills() {
			return milkMills;
		}

		public int getBeansGrams() {
			return beansGrams;
		}

		public int getPrice() {
			return price;
		}

		public static CoffeeType getByNumber(int number) {
			switch (number) {
				case 1:
					return ESPRESSO;
				case 2:
					return LATTE;
				default:
					return CAPPUCCINO;
			}
		}
	}

	private enum Action {
		BUY,
		FILL,
		TAKE,
		REMAINING,
		EXIT
	}
}
