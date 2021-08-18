package com.bad_java.homework.hyperskill.coffee_machine.part_1;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author Kirill Mololkin kir.mololkin@yandex.ru 10.08.2021
 */
public class MachineImpl implements Machine {

	private final PrintStream printWriter;

	public MachineImpl(PrintStream printWriter) {
		this.printWriter = printWriter;
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
}
