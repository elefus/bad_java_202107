package com.bad_java.lectures._04;

import java.io.FileNotFoundException;

public class HandlersException {

    public static void main(String[] args) throws FileNotFoundException {
        Thread main = Thread.currentThread();
        Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Received unhandled exception " + e + " from thread " + t);
            }
        };
        main.setUncaughtExceptionHandler(handler);


        throwableMethod();
    }

    public static void throwableMethod() {
        method2();
    }

    public static void method2() {
        method3();
    }

    public static void method3() {
        throw new RuntimeException() {
            @Override
            public String toString() {
                return "Hello world";
            }
        };
    }
}
