package com.bad_java.lectures._09;

public class VarargsExample {


    public static void main(String[] args) {
        method((Object) new Character[]{'A', 'B', 'C'});

    }

    private static void method(Object...args) {
        System.out.println(args.length);
    }
}
