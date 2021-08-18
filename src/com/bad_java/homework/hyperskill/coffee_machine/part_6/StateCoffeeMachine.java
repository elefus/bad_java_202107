package com.bad_java.homework.hyperskill.coffee_machine.part_6;

import machine.enums.CoffeeType;
import machine.enums.Ingredient;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kirill Mololkin Kirill-mol 12.08.2021
 */
public class StateCoffeeMachine {

	private State state;
	private final Terminal terminal;
	private final Map<Ingredient, Integer> ingredientsInMachine;


	public StateCoffeeMachine(Terminal terminal) {
		this.state = State.CHOOSE_ACTION;
		this.terminal = terminal;
		this.ingredientsInMachine = new HashMap<>(Map.of(
				Ingredient.WATER, 400,
				Ingredient.MILK, 540,
				Ingredient.BEANS, 120,
				Ingredient.CUPS, 9,
				Ingredient.MONEY, 550));
	}

	public boolean inputFromUser(String string) {

		switch (state) {
			case EXIT:
				return true;
			case CHOOSE_ACTION:
				terminal.println();
				chooseActionStateHandler(string);
				break;
			case CHOOSE_COFFEE:
				chooseCoffeeStateHandler(string);
				break;
			case FILL_WATER:
				increaseValueOfOneIngredient(Ingredient.WATER, Integer.parseInt(string));
				terminal.println("Write how many ml of milk you want to add:");
				state = State.FILL_MILK;
				break;
			case FILL_MILK:
				increaseValueOfOneIngredient(Ingredient.MILK, Integer.parseInt(string));
				terminal.println("Write how many grams of coffee beans you want to add:");
				state = State.FILL_BEANS;
				break;
			case FILL_BEANS:
				increaseValueOfOneIngredient(Ingredient.BEANS, Integer.parseInt(string));
				terminal.println("Write how many disposable cups of coffee you want to add:");
				state = State.FILL_CUPS;
				break;
			case FILL_CUPS:
				increaseValueOfOneIngredient(Ingredient.CUPS, Integer.parseInt(string));
				state = State.CHOOSE_ACTION;
				break;
		}

		if (state.equals(State.CHOOSE_ACTION)) {
			terminal.println();
			terminal.println("Write action (buy, fill, take, remaining, exit):");
		}


		return state.equals(State.EXIT);
	}

	private void chooseActionStateHandler(String actionString) {
		switch (actionString) {
			case "buy":
				state = State.CHOOSE_COFFEE;
				terminal.println("What do you want to buy? 1 - espresso, " +
						"2 - latte, 3 - cappuccino, back - to main menu:");
				break;
			case "fill":
				state = State.FILL_WATER;
				terminal.println("Write how many ml of water you want to add: ");
				break;
			case "take":
				takeMoneyFromMachine();
				state = State.CHOOSE_ACTION;
				break;
			case "remaining":
				printIngredientsInMachine();
				state = State.CHOOSE_ACTION;
				break;
			case "exit":
				state = State.EXIT;
				break;
			default:
				terminal.println("No such action, input another one!");
		}
	}

	private void chooseCoffeeStateHandler(String actionString) {
		switch (actionString) {
			case "1":
				createCoffee(CoffeeType.getByNumber(1));
				state = State.CHOOSE_ACTION;
				break;
			case "2":
				createCoffee(CoffeeType.getByNumber(2));
				state = State.CHOOSE_ACTION;
				break;
			case "3":
				createCoffee(CoffeeType.getByNumber(3));
				state = State.CHOOSE_ACTION;
				break;
			case "back":
				state = State.CHOOSE_ACTION;
				break;
			default:
				terminal.println("No such coffee type, try again!");
		}
	}

	private void printIngredientsInMachine() {
		terminal.println("The coffee machine has:");
		terminal.printf("%d ml of water%n", ingredientsInMachine.get(Ingredient.WATER));
		terminal.printf("%d ml of milk%n", ingredientsInMachine.get(Ingredient.MILK));
		terminal.printf("%d g of coffee beans%n", ingredientsInMachine.get(Ingredient.BEANS));
		terminal.printf("%d disposable cups%n", ingredientsInMachine.get(Ingredient.CUPS));
		terminal.printf("$%d of money%n", ingredientsInMachine.get(Ingredient.MONEY));
	}

	private void takeMoneyFromMachine() {
		terminal.printf("I gave you $%d%n", ingredientsInMachine.get(Ingredient.MONEY));
		ingredientsInMachine.put(Ingredient.MONEY, 0);
	}

	private void increaseValueOfOneIngredient(Ingredient ingredient, int value) {
		ingredientsInMachine.put(ingredient, ingredientsInMachine.get(ingredient) + value);
	}

	private void decreaseValueOfOneIngredient(Ingredient ingredient, int value) {
		ingredientsInMachine.put(ingredient, ingredientsInMachine.get(ingredient) - value);
	}

	private void createCoffee(CoffeeType coffeeType) {
		if (ingredientsInMachine.get(Ingredient.WATER) < coffeeType.getWaterMills()) {
			terminal.println("Sorry, not enough water!");
		} else if (ingredientsInMachine.get(Ingredient.MILK) < coffeeType.getMilkMills()) {
			terminal.println("Sorry, not enough milk!");
		} else if (ingredientsInMachine.get(Ingredient.BEANS) < coffeeType.getBeansGrams()) {
			terminal.println("Sorry, not enough coffee beans!");
		} else if (ingredientsInMachine.get(Ingredient.CUPS) < 1) {
			terminal.println("Sorry, not enough disposable cups!");
		} else {

			terminal.println("I have enough resources, making you a coffee!");

			decreaseValueOfOneIngredient(Ingredient.WATER, coffeeType.getWaterMills());
			decreaseValueOfOneIngredient(Ingredient.MILK, coffeeType.getMilkMills());
			decreaseValueOfOneIngredient(Ingredient.BEANS, coffeeType.getBeansGrams());
			decreaseValueOfOneIngredient(Ingredient.CUPS, 1);

			increaseValueOfOneIngredient(Ingredient.MONEY, coffeeType.getPrice());
		}
	}

	private enum State {
		CHOOSE_ACTION,
		CHOOSE_COFFEE,
		FILL_WATER,
		FILL_MILK,
		FILL_BEANS,
		FILL_CUPS,
		EXIT
	}
}
