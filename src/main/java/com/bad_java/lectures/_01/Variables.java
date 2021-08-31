package com.bad_java.lectures._01;

public class Variables {

    private int _privateField = 42;

    public static void main(String[] args) {
        // camelCase
        // snake_case
        // UpperCase
        int _$orderQty = 42;

        System.out.println(_$orderQty);

        boolean isActive = false, isArchived, isDone = true, isValid; // not recommend
        boolean isAllowed; // recommend

        final int x;
        if (args.length > 3) {
            x = 42;
        } else {
            x = 43;
        }

        final int i = 54;
        final int i1 = 545;
        int i2 = 23 + 323;

        System.out.println(x);

    }
}
