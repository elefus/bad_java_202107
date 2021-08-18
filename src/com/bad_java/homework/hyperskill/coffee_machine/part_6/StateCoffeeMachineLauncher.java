package com.bad_java.homework.hyperskill.coffee_machine.part_6;

/**
 * @author Kirill Mololkin Kirill-mol 15.08.2021
 */
public class StateCoffeeMachineLauncher implements Machine {

	private final StateCoffeeMachine stateCoffeeMachine;
	private final Terminal terminal;

	public StateCoffeeMachineLauncher(StateCoffeeMachine stateCoffeeMachine,
	                                  Terminal terminal) {
		this.stateCoffeeMachine = stateCoffeeMachine;
		this.terminal = terminal;
	}

	@Override
	public void run() {
		terminal.println("Write action (buy, fill, take, remaining, exit):");
		boolean isExit;
		do {
			String userInput = terminal.nextLine();
			isExit = stateCoffeeMachine.inputFromUser(userInput);
		} while (!isExit);
	}
}
