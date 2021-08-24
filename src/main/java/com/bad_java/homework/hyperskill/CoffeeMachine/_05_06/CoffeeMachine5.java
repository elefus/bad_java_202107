package com.bad_java.homework.hyperskill.CoffeeMachine._05_06;

public class CoffeeMachine5 {
    public static void main(String[] args) {
        Terminal terminal = new Terminal(System.in, System.out);
        Calculator calc = new Calculator(terminal);
        IngredientsRepository repository = new IngredientsRepository(9,
            400,
            540,
            120,
            550);
        CoffeeMachineService service = new CoffeeMachineService(repository, terminal);
        int exitCode = 0;
//        terminal.println("Starting to make a coffee");
//        grindingBeans(terminal);
//        boilingWater(terminal);
//        mixingCoffee(terminal;
//        pouringCoffee(terminal);
//        pouringMilk(terminal);
//        terminal.println("Coffee is ready!");

//        calc.calculateIngredients();
//        calc.calculateCups();
        while (exitCode != 1) {
            terminal.println(System.lineSeparator() + "Write action (buy, fill, take, remaining, exit):");
            exitCode = handleClient(terminal.readLine(), service, terminal);
        }

    }

    public static void grindingBeans(Terminal terminal){

        terminal.println("Grinding coffee beans");
    }

    public static void boilingWater(Terminal terminal){
        terminal.println("Boiling water");
    }

    public static void mixingCoffee(Terminal terminal){
        terminal.println("Mixing boiled water with crushed coffee beans");
    }

    public static void pouringCoffee(Terminal terminal){
        terminal.println("Pouring coffee into the cup");
    }

    public static void pouringMilk(Terminal terminal){
        terminal.println("Pouring some milk into the cup");
    }
    private static int handleClient (String command, CoffeeMachineService service, Terminal terminal) {
        switch (command) {
            case "buy": {
                terminal.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu::");
                service.buyCoffeeByType(terminal.readLine());
                return 0; // 0 - continue, 1 - exit
            }
            case "fill": {
                long cups;
                long water;
                long milk;
                long beans;

                terminal.println("Write how many ml of water you want to add:");
                water = terminal.inputInt();
                terminal.println("Write how many ml of milk you want to add:");
                milk = terminal.inputInt();
                terminal.println("Write how many grams of coffee beans you want to add:");
                beans = terminal.inputInt();
                terminal.println("Write how many disposable cups of coffee you want to add:");
                cups = terminal.inputInt();

                service.fillIngredients(water, milk, beans, cups);
                return 0; // 0 - continue, 1 - exit
            }
            case "take": {
                service.takeMoney();
                return 0; // 0 - continue, 1 - exit
            }
            case "remaining": {
                terminal.println(service.getStatus());
                return 0; // 0 - continue, 1 - exit
            }
            case "exit": {
                return 1; // 0 - continue, 1 - exit
            }
            default: {
                terminal.println("Wrong command. Please use: buy, fill, take, remaining or exit commands");
                return 0; // 0 - continue, 1 - exit
            }
        }
    }
}