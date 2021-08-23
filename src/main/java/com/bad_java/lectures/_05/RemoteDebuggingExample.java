package com.bad_java.lectures._05;

import java.util.concurrent.TimeUnit;

public class RemoteDebuggingExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Application started");
        for (int i = 0; i < 1000; i++) {
            System.out.println("Current stage is " + i);
            TimeUnit.SECONDS.sleep(3);
        }
    }
}
