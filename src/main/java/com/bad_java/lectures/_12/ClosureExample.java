package com.bad_java.lectures._12;

import java.util.ArrayList;
import java.util.List;

public class ClosureExample {

    private static final String CONST = "constant_value";

    private Runnable task;

    private int field = 55;

    public static void main(String[] args) {
        ClosureExample example = new ClosureExample();
        example.lambda();

        example.field = 100;

        example.task.run();
    }

    public void anonymous() {
        int value = 42;

        List<String> list = new ArrayList<>(List.of("1", "a"));

        ClosureExample _this = this;

        task = new Runnable() {
            @Override
            public void run() {
                Runnable _this = this;
                System.out.println(value);
                System.out.println(list);
                System.out.println(field);
                System.out.println(CONST);
            }
        };

        task.run();

        list.add("3");
    }

    public void lambda() {
        int value = 42;

        List<String> list = new ArrayList<>(List.of("1", "a"));

        ClosureExample _this = this;

        task = () -> {
            ClosureExample _this2 = this;

            System.out.println(value);
            System.out.println(list);
            System.out.println(field);
            System.out.println(CONST);
        };

        task.run();

        list.add("3");
    }

    public static void staticMethod() {
//        Runnable task = () -> System.out.println(this); // ERROR

        new Runnable() {
            @Override
            public void run() {
                Runnable task = () -> System.out.println(this);
            }
        };
    }

}
