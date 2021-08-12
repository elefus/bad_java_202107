package com.bad_java.homework.hyperskill.CoffeeMachineProject;

import java.util.ArrayList;
import java.util.List;

public class Operation {

    private String operation;
    private static List<Operation> operationList;

    public Operation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    static {
        operationList = new ArrayList<>();
        operationList.add(new Operation("Starting to make a coffee"));
        operationList.add(new Operation("Grinding coffee beans"));
        operationList.add(new Operation("Boiling water"));
        operationList.add(new Operation("Mixing boiled water with crushed coffee beans"));
        operationList.add(new Operation("Pouring coffee into the cup"));
        operationList.add(new Operation("Pouring some milk into the cup"));
        operationList.add(new Operation("Coffee is ready!"));
    }

    public static void getAllOperations() {
        for (Operation operation1 : operationList) {
            System.out.println(operation1.getOperation());
        }
    }
}
