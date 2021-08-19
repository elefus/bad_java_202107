package com.bad_java.homework.hyperskill.CoffeeMachineProject;

enum State {
    BUY("buy"),
    ADDING_SUPPLY("fill"),
    TAKING_MONEY("take"),
    REVISION_OF_REMAINING("remaining"),
    EXIT("exit");

    String operation;

    State(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

}