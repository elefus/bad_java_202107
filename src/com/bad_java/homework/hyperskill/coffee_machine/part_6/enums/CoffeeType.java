package com.bad_java.homework.hyperskill.coffee_machine.part_6.enums;

public enum CoffeeType {
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
