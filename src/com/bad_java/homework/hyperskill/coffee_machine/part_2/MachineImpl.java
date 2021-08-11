package com.bad_java.homework.hyperskill.coffee_machine.part_2;

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

    public MachineImpl(OutputStream outputStream, InputStream inputStream) {
        this.printWriter = new PrintStream(outputStream);
        this.scanner = new Scanner(inputStream);
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
        int cups = readNumberOfCups();
        printWriter.printf("For %d cups of coffee you will need:%n", cups);
        List<Integer> ingredientsAmount = calculateIngredientsAmount(cups);
        printWriter.printf("%d ml of water%n", ingredientsAmount.get(0));
        printWriter.printf("%d ml of milk%n", ingredientsAmount.get(1));
        printWriter.printf("%d g of coffee beans%n", ingredientsAmount.get(2));

    }

    private int readNumberOfCups() {
        return scanner.nextInt();
    }

    private List<Integer> calculateIngredientsAmount(int cups) {
        return List.of(200 * cups, 50 * cups, 15 * cups);
    }
}
