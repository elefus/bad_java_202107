package com.bad_java.lectures._05;

public class DebugExample {

    public static String staticField = "STATIC";
    public static String staticField2 = "STATIC";

    public static void main(String[] args) {
        method();
    }

    public static void method() {
        int i = 42;
        i += 6;
        System.out.println(i);
        System.out.println("Hello from method!");
        System.out.println(staticField);
    }
}
