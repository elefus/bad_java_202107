package com.bad_java.homework.hyperskill.coffee_machine;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeMachineTerminal {

    private final Map<String, Runnable> actions = new LinkedHashMap<>() {{
        put("buy", CoffeeMachineTerminal.this::buy);
        put("fill", CoffeeMachineTerminal.this::fill);
        put("take", CoffeeMachineTerminal.this::take);
        put("remaining", CoffeeMachineTerminal.this::remaining);
        put("exit", () -> {});
    }};

    private final CoffeeMachine machine;
    private final Scanner in;
    private final PrintStream out;

    CoffeeMachineTerminal(Scanner userInput, PrintStream userOutput, CoffeeMachine machine) {
        this.machine = machine;
        this.in = userInput;
        this.out = userOutput;
    }

    public void start() {
        do {
            out.println("Write action (" + String.join(", ", actions.keySet()) + "):");
            out.print("> ");
            String action = in.nextLine();

            if (action.equals("exit")) {
                return;
            }
            out.println();
            actions.getOrDefault(action, () -> out.println("Unknown action required!")).run();
            out.println();
        } while (true);
    }

    private void remaining() {
        out.println("Coffee machine has:");
        machine.getSupplies().forEach((ingredient, amount) -> out.println(amount + " of " + ingredient.getName()));
        out.println(machine.money + " of money");
    }

    private void buy() {
        out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        out.print("> ");
        CoffeeSort coffeeSort;
        switch (in.nextLine()) {
            case "1":
                coffeeSort = CoffeeSort.ESPRESSO;
                break;

            case "2":
                coffeeSort = CoffeeSort.LATTE;
                break;

            case "3":
                coffeeSort = CoffeeSort.CAPPUCCINO;
                break;

            case "back":
                return;

            default:
                out.println("Unknown type of coffee!");
                return;
        }
        try {
            machine.make(coffeeSort);
            out.println("I have enough resources, making you a coffee!");
        } catch (IllegalStateException ex) {
            out.println(ex.getMessage());
        }
    }

    private void fill() {
        for (Ingredient ingredient : Ingredient.values()) {
            out.printf("Write how many %s of %s do you want to add:%n", ingredient.getUnits(), ingredient.getName());
            out.print("> ");
            int amount = Integer.parseInt(in.nextLine());
            machine.supplyIngredient(ingredient, amount);
        }
    }

    private void take() {
        out.println("I gave you $" + machine.extractMoney());
    }
}